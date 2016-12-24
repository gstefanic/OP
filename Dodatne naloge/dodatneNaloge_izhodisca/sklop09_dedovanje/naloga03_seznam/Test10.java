
import java.util.*;

public class Test10 {

    public static void main(String[] args) {
        System.out.println( s().toString() );
        System.out.println( s(10).toString() );
        System.out.println( s(12345, -456789).toString() );
        System.out.println( s(-2, -3, -4, -5).toString() );
        System.out.println( s(50, 20, 60, 30, 10, 70, 80, 40, 50, 60).toString() );
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
