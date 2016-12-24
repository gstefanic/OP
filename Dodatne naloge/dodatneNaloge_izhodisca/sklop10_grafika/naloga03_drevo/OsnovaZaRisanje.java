
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;

/**
 * Namen tega razreda je, da se risanje na risalno plo"s"co in v datoteko PNG
 * spravi na skupni imenovalec.  Podrazred mora implementirati metodo narisi
 * in v njej zapisati kodo za risanje.  Ob klicu metode sproziRisanje se na
 * podlagi argumentov ukazne vrstice, ki se metodi posredujejo, ustvari bodisi
 * datoteka PNG (vanjo se shrani slika, ki jo proizvede metoda narisi) ali pa
 * grafi"cno okno in risalna plo"s"ca.  Vsakokrat, ko je vsebino plo"s"ce
 * treba osve"ziti (torej ob vsakem klicu metode paintComponent na objektu, ki
 * predstavlja plo"s"co), se pokli"ce metoda narisi.  Slika, ki jo metoda
 * nari"se, se prika"ze na risalni plo"s"ci.
 *
 * Razred ponuja tudi koristno pomo"zno metodo ri, ki realno "stevilo pretvori
 * v najbli"zje celo.
 */

public abstract class OsnovaZaRisanje {

    /** Vrne zaokro"zitev "stevila d na najbli"zje celo "stevilo. */
    public static int ri(double d) {
        return (int) Math.round(d);
    }

    /** privzeta "sirina platna, "ce velikost ni podana */
    private static final int PRIVZETA_SIRINA_PLATNA = 800;

    /** privzeta vi"sina platna, "ce velikost ni podana */
    private static final int PRIVZETA_VISINA_PLATNA = 600;

    /**
     * Nari"se sliko na `platno' "sirine wPlatno in vi"sine hPlatno, ki ga
     * predstavlja objekt g.  Ta metoda se pokli"ce, ko je treba bodisi
     * narisati sliko, ki se bo shranila v datoteko PNG, ali pa osve"ziti
     * vsebino risalne plo"s"ce.
     *
     * @param g objekt, ki predstavlja platno
     * @param wPlatno "sirina platna (dejansko celo "stevilo, a zaradi
     *                enostavnosti pretvorjeno v double)
     * @param hPlatno vi"sina platna (dejansko celo "stevilo, a zaradi
     *                enostavnosti pretvorjeno v double)
     */
    protected abstract void narisi(Graphics2D g, double wPlatno, double hPlatno);

    /** 
     * Na podlagi podanih argumentov ukazne vrstice bodisi ustvari datoteko
     * PNG in pokli"ce metodo narisi, da nari"se njeno vsebino, ali pa ustvari
     * grafi"cno okno in risalno plo"s"co, pri "cemer se bo vsebina risalne
     * plo"s"ce osve"zevala s klici metode narisi.
     */
    public void sproziRisanje(String[] args) {
        try {
            int wPlatno = PRIVZETA_SIRINA_PLATNA;
            int hPlatno = PRIVZETA_VISINA_PLATNA;
            File datoteka = null;

            // obdelaj argumente ukazne vrstice
            for (int i = 0;  i < args.length;  i++) {
                if (args[i].indexOf(".") >= 0) {
                    String[] imeKoncnica = args[i].split("\\.");
                    String koncnica = imeKoncnica[imeKoncnica.length - 1];
                    if (!koncnica.equals("png")) {
                        throw new IllegalArgumentException("Datoteka mora imeti končnico .png");
                    }
                    datoteka = new File(args[i]);

                } else if (args[i].indexOf("x") >= 0) {
                    String[] wh = args[i].split("x");
                    wPlatno = Integer.parseInt(wh[0]);
                    hPlatno = Integer.parseInt(wh[1]);

                } else {
                    throw new RuntimeException();
                }
            }

            // V odvisnosti od tipa platna ustvari okno in plo"s"co oziroma
            // pomnilni"sko sliko.  V primeru izdelave pomnilni"ske slike
            // pokli"ci metodo `narisi' in shrani izdelano sliko v datoteko.
            // V primeru izdelave okna pa se bo metoda `narisi' poklicala
            // preko metode paintComponent risalne plo"s"ce.

            if (datoteka == null) {
                this.ustvariOknoInPlosco(wPlatno, hPlatno);
            } else {
                this.izdelajPNG(wPlatno, hPlatno, datoteka);
            }

        } catch (IllegalArgumentException ex) {
            System.err.println("====================================");
            System.err.println(ex.getMessage());
            System.err.println("====================================");
            izpisiNavodila();

        } catch (RuntimeException ex) {
            // nekaj je narobe; izpi"si navodila za uporabo
            izpisiNavodila();
        }
    }

    /**
     * Na standardni izhod za napake izpi"se navodila za uporabo.
     */
    private static void izpisiNavodila() {
        System.err.println("java ... [<datoteka.png>] [<sirina>x<visina>]");
        System.err.println();
        System.err.println("java ...");
        System.err.println("    sliko nariše v okno velikosti 800 krat 600");
        System.err.println();
        System.err.println("java ... 640x480");
        System.err.println("    sliko nariše v okno velikosti 640 krat 480");
        System.err.println();
        System.err.println("java ... primer.png");
        System.err.println("    izdela sliko primer.png velikosti 800 krat 600");
        System.err.println();
        System.err.println("java ... primer.png 640x480");
        System.err.println("    izdela sliko primer.png velikosti 640 krat 480");
    }

    /**
     * Izdela pomnilni"sko sliko, pokli"ce metodo `narisi' in shrani izris v
     * podano datoteko PNG.
     */
    private void izdelajPNG(int wSlika, int hSlika, File datoteka) {
        BufferedImage slika = new BufferedImage(wSlika, hSlika, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = slika.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, wSlika, hSlika);
        this.narisi(g, wSlika, hSlika);
        g.dispose();

        try {
            ImageIO.write(slika, "png", datoteka);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

    /**
     * Ustvari in prika"ze okno in risalno plo"s"co.  Vsebina risalne plo"s"ce
     * se bo osve"zevala s klici metode narisi.
     */
    private void ustvariOknoInPlosco(final int wOkno, final int hOkno) {

        // Swingove komponente lahko izdelujemo in posodabljamo samo takrat,
        // ko te"ce dogodkovna nit (EDT).  Metoda invokeLater po"caka, da ta
        // nit pride na vrsto.  Ko se to zgodi, izvede metodo run objekta tipa
        // Runnable, ki ga prejme kot parameter.

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // izdelaj okno
                JFrame okno = new JFrame("Piramida");
                okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // okno postavi na sredino zaslona
                Dimension dZaslon = Toolkit.getDefaultToolkit().getScreenSize();
                int xOkno = (dZaslon.width - wOkno) / 2;
                int yOkno = (dZaslon.height - hOkno) / 2;
                okno.setBounds(xOkno, yOkno, wOkno, hOkno);

                // izdelaj plo"s"co in jo poka"zi na okno
                okno.setLayout(new BorderLayout());
                JPanel risalnaPlosca = OsnovaZaRisanje.this.new RisalnaPlosca();
                okno.add(risalnaPlosca, BorderLayout.CENTER);

                // prika"zi okno
                okno.setVisible(true);
            }
        });
    }

    /**
     * Objekt tega razreda predstavlja risalno plo"s"co.  Ker je razred
     * nestati"cen, njegov objekt ob izdelavi prejme referenco na objekt
     * razreda OsnovaZaRisanje, s katerim je bil izdelan.  Do tega objekta
     * lahko dostopamo z izrazom OsnovaZaRisanje.this.
     *
     * Ob vsakem klicu metode paintComponent se bo na objektu
     * OsnovaZaRisanje.this poklicala metoda narisi.  Izris, ki ga proizvede
     * ta metoda, se bo prikazal na risalni plo"s"ci.
     */
    private class RisalnaPlosca extends JPanel {

        public RisalnaPlosca() {
            this.setBackground(Color.WHITE);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            OsnovaZaRisanje.this.narisi((Graphics2D) g, this.getWidth(), this.getHeight());
        }
    }
}
