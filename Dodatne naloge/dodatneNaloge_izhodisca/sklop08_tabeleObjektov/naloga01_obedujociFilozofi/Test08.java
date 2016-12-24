
public class Test08 {

    public static void main(String[] args) {
        Filozof a = new Filozof();
        Filozof b = new Filozof();
        Filozof c = new Filozof();
        a.nastaviSoseda(b, c);
        b.nastaviSoseda(c, a);
        c.nastaviSoseda(a, b);

        System.out.println(a.steviloFilozofov());
        System.out.println(b.steviloFilozofov());
        System.out.println(c.steviloFilozofov());
    }
}
