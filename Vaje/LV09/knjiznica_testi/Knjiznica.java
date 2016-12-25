public class Knjiznica {

    int[] naslovi;
    int[][] posoje;
    int stClanov, stNaslovov;

    public Knjiznica(int stClanov, int stNaslovov) {
        this.stClanov = stClanov;
        this.stNaslovov = stNaslovov;
        this.posoje = new int[stClanov][stNaslovov];
        this.naslovi = new int[stNaslovov];
        
        for (int i = 0; i < stNaslovov; i++) {
            naslovi[i] = 10;
        }
    }

    public void posodi(int clan, int naslov) {
        if (naslovi[naslov] != 0) {
            this.posoje[clan][naslov] += 1;
            naslovi[naslov] --;
        }
    }

    public void pridobiNazaj(int clan) {
        for (int i = 0; i < posoje[clan].length; i++) {
            naslovi[i] += posoje[clan][i];
            posoje[clan][i] = 0;
        }
    }

    public int naVoljo(int naslov) {
        return naslovi[naslov];
    }

    public int posojeni(int clan, int naslov) {
        return posoje[clan][naslov];
    }

    public int posojeni() {
        int stevec = 0;
        for (int i = 0; i < stNaslovov; i++) {
            stevec += (10 - naslovi[i]);
        }
        return stevec;
    }

    public int najClan(int naslov) {
        int najClan = 0;
        for (int i = 1; i < stClanov; i++) {
            if (posoje[i][naslov] > posoje[najClan][naslov]) {
                najClan = i;
            }
        }
        return najClan;
    }


}