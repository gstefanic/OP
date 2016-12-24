
public class Test01 {

    public static void main(String[] args) {
        Filozof a = new Filozof();
        Filozof b = new Filozof();
        Filozof c = new Filozof();
        a.nastaviSoseda(b, c);
        b.nastaviSoseda(c, a);
        c.nastaviSoseda(a, b);

        System.out.println(a.kolikoPalicicDrzi());
        System.out.println(b.kolikoPalicicDrzi());
        System.out.println(c.kolikoPalicicDrzi());
        System.out.println("----------");

        a.primiLevo();
        b.primiLevo();
        c.primiLevo();
        System.out.println(a.kolikoPalicicDrzi());
        System.out.println(b.kolikoPalicicDrzi());
        System.out.println(c.kolikoPalicicDrzi());
        System.out.println("----------");

        a.primiDesno();
        b.primiDesno();
        c.primiDesno();
        System.out.println(a.kolikoPalicicDrzi());
        System.out.println(b.kolikoPalicicDrzi());
        System.out.println(c.kolikoPalicicDrzi());
        System.out.println("----------");

        a.izpustiDesno();
        b.izpustiDesno();
        c.izpustiDesno();
        System.out.println(a.kolikoPalicicDrzi());
        System.out.println(b.kolikoPalicicDrzi());
        System.out.println(c.kolikoPalicicDrzi());
        System.out.println("----------");

        a.izpustiLevo();
        b.izpustiLevo();
        c.izpustiLevo();
        System.out.println(a.kolikoPalicicDrzi());
        System.out.println(b.kolikoPalicicDrzi());
        System.out.println(c.kolikoPalicicDrzi());
        System.out.println("----------");

        b.primiLevo();
        b.primiDesno();
        c.primiLevo();
        c.primiDesno();
        a.primiLevo();
        a.primiDesno();
        System.out.println(a.kolikoPalicicDrzi());
        System.out.println(b.kolikoPalicicDrzi());
        System.out.println(c.kolikoPalicicDrzi());
    }
}
