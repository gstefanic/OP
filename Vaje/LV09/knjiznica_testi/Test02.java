
public class Test02 {

    public static void main(String[] args) {
        int stClanov = 3;
        int stNaslovov = 2;
        Knjiznica knjiznica = new Knjiznica(stClanov, stNaslovov);

        knjiznica.posodi(0, 1);
        knjiznica.posodi(1, 1);
        knjiznica.posodi(2, 1);
        System.out.println(knjiznica.naVoljo(0));
        System.out.println(knjiznica.naVoljo(1));
        System.out.println("------------------------------");

        knjiznica.posodi(2, 1);
        knjiznica.posodi(1, 1);
        knjiznica.posodi(0, 1);
        System.out.println(knjiznica.naVoljo(0));
        System.out.println(knjiznica.naVoljo(1));
        System.out.println("------------------------------");

        knjiznica.posodi(1, 1);
        knjiznica.posodi(0, 1);
        knjiznica.posodi(2, 1);
        System.out.println(knjiznica.naVoljo(0));
        System.out.println(knjiznica.naVoljo(1));
        System.out.println("------------------------------");

        knjiznica.posodi(2, 1);
        knjiznica.posodi(0, 1);
        knjiznica.posodi(1, 1);
        System.out.println(knjiznica.naVoljo(0));
        System.out.println(knjiznica.naVoljo(1));
    }
}
