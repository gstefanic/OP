
import java.util.*;

public class Test05 {

    public static void main(String[] args) {
        System.out.println( s(-2, -3, -4, -5).vsebuje(-5) );
        System.out.println( s(-2, -3, -4, -5).vsebuje(-6) );
        System.out.println( s(-2, -3, -4, -5).vsebuje(-3) );
        System.out.println( s(-2, -3, -4, -5).vsebuje(-2) );
        System.out.println( s(-2, -3, -4, -5).vsebuje(-1) );
        System.out.println( s().vsebuje(0) );
        System.out.println( s(0).vsebuje(10) );
        System.out.println( s(0).vsebuje(0) );
        System.out.println( s(20, 10, 50, 40, 90, 30, 60).vsebuje(80) );
        System.out.println( s(20, 10, 50, 40, 90, 30, 60).vsebuje(60) );
        System.out.println( s(20, 10, 50, 40, 90, 30, 60).vsebuje(10) );
        System.out.println( s(20, 10, 50, 40, 90, 30, 60).vsebuje(20) );
        System.out.println( s(20, 10, 50, 40, 90, 30, 60).vsebuje(70) );
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
