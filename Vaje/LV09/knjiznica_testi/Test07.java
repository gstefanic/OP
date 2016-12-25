
public class Test07 {

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
        System.out.println(knjiznica.posojeni());

        knjiznica.pridobiNazaj(0);
        System.out.println(knjiznica.posojeni());

        knjiznica.pridobiNazaj(1);
        System.out.println(knjiznica.posojeni());
    }
}
