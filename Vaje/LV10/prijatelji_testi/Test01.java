
public class Test01 {

    public static void main(String[] args) {
        PostniNaslov[] naslovi = new PostniNaslov[9];
        naslovi[0] = new PostniNaslov("Sprednja 7", 1000, "Ljubljana");
        naslovi[1] = new PostniNaslov("Zadnja 11",  2000, "Maribor");
        naslovi[2] = new PostniNaslov("Zgornja 6",  3000, "Celje");
        naslovi[3] = new PostniNaslov("Spodnja 9",  4000, "Kranj");
        naslovi[4] = new PostniNaslov("Velika 10",  5000, "Nova Gorica");
        naslovi[5] = new PostniNaslov("Mala 2",     6000, "Koper");
        naslovi[6] = new PostniNaslov("Sprednja 8", 1000, "Ljubljana");
        naslovi[7] = new PostniNaslov("Zadnja 11",  2000, "Maribor");
        naslovi[8] = new PostniNaslov("Sprednja 7", 2000, "Maribor");

        for (int i = 0;  i < naslovi.length;  i++) {
            System.out.println(naslovi[i].toString());
        }
    }
}
