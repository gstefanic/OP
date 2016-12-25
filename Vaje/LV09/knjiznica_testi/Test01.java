
public class Test01 {

    public static void main(String[] args) {
        int stClanov = 3;
        int stNaslovov = 5;
        Knjiznica knjiznica = new Knjiznica(stClanov, stNaslovov);
        System.out.println("Na zacetku:");
        for (int i = 0;  i < stNaslovov;  i++) {
            System.out.printf("Knjiznica ima na voljo %d izvodov naslova %d%n", knjiznica.naVoljo(i), i);
        }

        knjiznica.posodi(0, 1);
        knjiznica.posodi(0, 1);
        knjiznica.posodi(1, 2);
        knjiznica.posodi(1, 4);
        knjiznica.posodi(2, 0);
        knjiznica.posodi(2, 3);
        knjiznica.posodi(2, 4);
        System.out.println("Po izposojah:");
        for (int i = 0;  i < stNaslovov;  i++) {
            System.out.printf("Knjiznica ima na voljo %d izvodov naslova %d%n", knjiznica.naVoljo(i), i);
        }
    }
}
