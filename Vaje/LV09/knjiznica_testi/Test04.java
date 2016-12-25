
public class Test04 {

    public static void main(String[] args) {
        int stClanov = 3;
        int stNaslovov = 2;
        Knjiznica knjiznica = new Knjiznica(stClanov, stNaslovov);

        knjiznica.posodi(0, 1);
        knjiznica.posodi(1, 1);
        knjiznica.posodi(2, 1);
        izpisi(knjiznica, stClanov, stNaslovov);

        knjiznica.posodi(2, 1);
        knjiznica.posodi(1, 1);
        knjiznica.posodi(0, 1);
        izpisi(knjiznica, stClanov, stNaslovov);

        knjiznica.posodi(1, 1);
        knjiznica.posodi(0, 1);
        knjiznica.posodi(2, 1);
        izpisi(knjiznica, stClanov, stNaslovov);

        knjiznica.posodi(2, 1);
        knjiznica.posodi(0, 1);
        knjiznica.posodi(1, 1);
        izpisi(knjiznica, stClanov, stNaslovov);
    }

    private static void izpisi(Knjiznica knjiznica, int stClanov, int stNaslovov) {
        for (int clan = 0;  clan < stClanov;  clan++) {
            for (int naslov = 0;  naslov < stNaslovov;  naslov++) {
                System.out.printf("%3d", knjiznica.posojeni(clan, naslov));
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
}
