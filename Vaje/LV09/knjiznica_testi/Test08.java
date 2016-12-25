
public class Test08 {

    public static void main(String[] args) {
        int stClanov = 2;
        int stNaslovov = 5;
        Knjiznica knjiznica = new Knjiznica(stClanov, stNaslovov);

        knjiznica.posodi(0, 1);
        knjiznica.posodi(0, 1);
        knjiznica.posodi(0, 4);
        knjiznica.posodi(1, 0);
        knjiznica.posodi(1, 0);
        knjiznica.posodi(1, 3);
        izpisi(knjiznica, stNaslovov);

        knjiznica.pridobiNazaj(0);
        izpisi(knjiznica, stNaslovov);

        knjiznica.pridobiNazaj(1);
        izpisi(knjiznica, stNaslovov);
    }

    private static void izpisi(Knjiznica knjiznica, int stNaslovov) {
        for (int naslov = 0;  naslov < stNaslovov;  naslov++) {
            System.out.printf("%3d", knjiznica.najClan(naslov));
        }
        System.out.println();
    }
}
