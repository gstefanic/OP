
public class Oseba {

    private String ip;   // ime in priimek
    private int starost;
    private PostniNaslov postniNaslov;
    private Oseba[] prijatelji;

    /*
     * Ustvari nov objekt razreda Oseba.  Tabele prijateljev ne nastavi.
     */
    public Oseba(String ip, int starost, PostniNaslov postniNaslov) {
        this.ip = ip;
        this.starost = starost;
        this.postniNaslov = postniNaslov;

        // zagotovi veljavnost tabele prijateljev, tudi če se metoda
        // nastaviPrijatelje nikoli ne pokliče
        this.prijatelji = new Oseba[0];
    }

    /*
     * Nastavi prijatelje osebe <this>.
     */
    public void nastaviPrijatelje(Oseba[] prijatelji) {
        this.prijatelji = prijatelji;
    }

    /*
     * Vrne predstavitev osebe <this> v obliki niza.
     */
    public String toString() {
        return "";
    }

    /*
     * Vrne <true> natanko v primeru, če oseba <os> prebiva na istem naslovu
     * kot oseba <this>.
     */
    public boolean naIstemNaslovuKot(Oseba os) {
        return false;
    }

    /*
     * Vrne število prijateljev osebe <this>, ki živijo na istem naslovu kot
     * oseba <this>.
     */
    public int steviloPrijateljevNaIstemNaslovu() {
        return 0;
    }

    /*
     * Vrne najstarejšega prijatelja osebe <this> (prvega, če jih je več;
     * null, če jih ni).
     */
    public Oseba najstarejsiPrijatelj() {
        return null;
    }

    /*
     * Vrne <true> natanko v primeru, če je oseba <this> prijatelj osebe <os>.
     */
    public boolean jePrijateljOd(Oseba os) {
        return false;
    }

    /*
     * Vrne matriko prijateljstev za dano tabelo oseb (rezultat[i][j] == true
     * natanko tedaj, ko je oseba j prijatelj osebe i).
     */
    public static boolean[][] prijateljstva(Oseba[] osebe) {
        return null;
    }
}
