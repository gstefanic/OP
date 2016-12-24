
import java.util.*;

public class Test04 {

    public static void main(String[] args) {
        System.out.println( s2l(s().dodajU(10)) );
        System.out.println( s2l(s().dodajU(-10)) );
        System.out.println( s2l(s().dodajU(0)) );

        System.out.println( s2l(s(30).dodajU(10)) );
        System.out.println( s2l(s(30).dodajU(50)) );

        System.out.println( s2l(s(10, 20, 30).dodajU(5)) );
        System.out.println( s2l(s(10, 20, 30).dodajU(10)) );
        System.out.println( s2l(s(10, 20, 30).dodajU(15)) );
        System.out.println( s2l(s(10, 20, 30).dodajU(20)) );
        System.out.println( s2l(s(10, 20, 30).dodajU(25)) );
        System.out.println( s2l(s(10, 20, 30).dodajU(30)) );
        System.out.println( s2l(s(10, 20, 30).dodajU(35)) );

        System.out.println( s2l(s(-70, -60, -50, -40, -30, -20, -10).dodajU(-80)) );
        System.out.println( s2l(s(-70, -60, -50, -40, -30, -20, -10).dodajU(-55)) );
        System.out.println( s2l(s(-70, -60, -50, -40, -30, -20, -10).dodajU(-25)) );
        System.out.println( s2l(s(-70, -60, -50, -40, -30, -20, -10).dodajU(-5)) );
    }

    private static Seznam s(Integer... elementi) {
        return s0(elementi, 0, elementi.length);
    }

    private static Seznam s0(Integer[] elementi, int ixZac, int ixKon) {
        if (ixZac == ixKon) {
            return new Prazen();
        }
        return new Neprazen(elementi[ixZac], s0(elementi, ixZac + 1, ixKon));
    }

    private static LinkedList<Integer> s2l(Seznam seznam) {
        if (seznam.jePrazen()) {
            return new LinkedList<Integer>();
        }
        LinkedList<Integer> lst = s2l(seznam.rep());
        lst.offerFirst(seznam.glava());
        return lst;
    }
}
