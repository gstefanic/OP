
public class Naslov {

    private String ulicaHS;  // ulica s hi"sno "stevilko
    private int postnaStevilka;
    private String posta;

    /** Ustvari nov objekt razreda Naslov. */
    public Naslov(String ulicaHS, int postnaStevilka, String posta) {
        this.ulicaHS = ulicaHS;
        this.postnaStevilka = postnaStevilka;
        this.posta = posta;
    }

    /** 
     * Vrne predstavitev naslova this v obliki niza.
     */
    public String toString() {
        return String.format("%s, %d %s", this.ulicaHS, this.postnaStevilka, this.posta);
    }

    /** 
     * Vrne `true' natanko v primeru, "ce objekt `n' predstavlja enak naslov
     * kot objekt `this'.
     */
    public boolean jeEnakKot(Naslov n) {
        return (this.ulicaHS.equals(n.ulicaHS)
                && this.postnaStevilka == n.postnaStevilka
                && this.posta.equals(n.posta));
    }
}
