
public class Test09 {

    public static void main(String[] args) {
        int stClanov = 4;
        int stNaslovov = 3;
        Knjiznica knjiznica = new Knjiznica(stClanov, stNaslovov);

        knjiznica.posodi(0, 2);
        knjiznica.posodi(0, 2);
        knjiznica.posodi(0, 2);

        knjiznica.posodi(1, 2);
        knjiznica.posodi(1, 2);
        knjiznica.posodi(1, 2);
        knjiznica.posodi(1, 2);

        knjiznica.posodi(2, 2);
        knjiznica.posodi(2, 2);

        knjiznica.posodi(3, 2);
        knjiznica.posodi(3, 2);
        knjiznica.posodi(3, 2);
        knjiznica.posodi(3, 2);

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
