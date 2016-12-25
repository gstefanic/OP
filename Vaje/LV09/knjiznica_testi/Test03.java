
public class Test03 {

    public static void main(String[] args) {
        int stClanov = 3;
        int stNaslovov = 5;
        Knjiznica knjiznica = new Knjiznica(stClanov, stNaslovov);
        System.out.println("Na zacetku:");
        for (int clan = 0;  clan < stClanov;  clan++) {
            for (int naslov = 0;  naslov < stNaslovov;  naslov++) {
                System.out.printf("%3d", knjiznica.posojeni(clan, naslov));
            }
            System.out.println();
        }

        knjiznica.posodi(0, 1);
        knjiznica.posodi(0, 1);
        knjiznica.posodi(1, 2);
        knjiznica.posodi(1, 4);
        knjiznica.posodi(2, 0);
        knjiznica.posodi(2, 3);
        knjiznica.posodi(2, 4);
        System.out.println("Po izposojah:");
        for (int clan = 0;  clan < stClanov;  clan++) {
            for (int naslov = 0;  naslov < stNaslovov;  naslov++) {
                System.out.printf("%3d", knjiznica.posojeni(clan, naslov));
            }
            System.out.println();
        }
    }
}
