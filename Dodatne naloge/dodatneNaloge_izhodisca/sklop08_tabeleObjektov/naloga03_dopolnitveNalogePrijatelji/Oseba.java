
public class Oseba {

    private String ip;   // ime in priimek
    private int starost;
    private Naslov naslov;
    private Oseba[] prijatelji;

    /** Ustvari nov objekt razreda Oseba.  Tabele prijateljev ne nastavi. */
    public Oseba(String ip, int starost, Naslov naslov) {
        this.ip = ip;
        this.starost = starost;
        this.naslov = naslov;

        // zagotovi veljavnost tabele prijateljev, tudi "ce se metoda
        // nastaviPrijatelje nikoli ne pokli"ce
        this.prijatelji = new Oseba[0];
    }

    /** Nastavi prijatelje osebe `this'. */
    public void nastaviPrijatelje(Oseba[] prijatelji) {
        this.prijatelji = prijatelji;
    }

    /** 
     * Vrne predstavitev osebe `this' v obliki niza.
     */
    public String toString() {
        return String.format("%s (%d), %s",
                this.ip, this.starost, this.naslov.toString());
    }

    /**
     * Vrne `true' natanko v primeru, "ce oseba `os' prebiva na istem naslovu
     * kot oseba `this'.
     */
    public boolean naIstemNaslovuKot(Oseba os) {
        return this.naslov.jeEnakKot(os.naslov);
    }

    /**
     * Vrne "stevilo prijateljev osebe `this', ki "zivijo na istem naslovu kot
     * oseba `this'.
     */
    public int steviloPrijateljevNaIstemNaslovu() {
        int stevilo = 0;
        for (int i = 0;  i < this.prijatelji.length;  i++) {
            if (this.prijatelji[i].naIstemNaslovuKot(this)) {
                stevilo++;
            }
        }
        return stevilo;
    }

    /**
     * Vrne najstarej"sega prijatelja osebe `this' (prvega, "ce jih je ve"c;
     * null, "ce jih ni).
     */
    public Oseba najstarejsiPrijatelj() {
        if (this.prijatelji.length == 0) {
            return null;
        }
        int iNaj = 0;
        for (int i = 1;  i < this.prijatelji.length;  i++) {
            if (this.prijatelji[i].starost > this.prijatelji[iNaj].starost) {
                iNaj = i;
            }
        }
        return this.prijatelji[iNaj];
    }

    /**
     * Vrne `true' natanko v primeru, "ce je oseba `this' prijatelj osebe `os'.
     */
    public boolean jePrijateljOd(Oseba os) {
        for (int i = 0;  i < os.prijatelji.length;  i++) {
            if (os.prijatelji[i] == this) {
                return true;
            }
        }
        return false;
    }

    /**
     * Vrne matriko prijateljstev za dano tabelo oseb.
     * @return matrika[i][j] == true natanko tedaj, ko je oseba j prijatelj
     * osebe i.
     */
    public static boolean[][] prijateljstva(Oseba[] osebe) {
        boolean[][] prijateljstva = new boolean[osebe.length][osebe.length];
        for (int i = 0;  i < osebe.length;  i++) {
            for (int j = 0;  j < osebe.length;  j++) {
                prijateljstva[i][j] = osebe[j].jePrijateljOd(osebe[i]);
            }
        }
        return prijateljstva;
    }
}
