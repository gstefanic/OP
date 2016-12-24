
import java.util.*;

public class Test03 {

    public static void main(String[] args) {
        System.out.println( s2l(s(-2, -3, -4, -5).dodajK(-6)) );
        System.out.println( s2l(s(50).dodajK(60)) );
        System.out.println( s2l(s(15, 30).dodajK(45)) );
        System.out.println( s2l(s().dodajK(20)) );
        System.out.println( s2l(s(20, 10, 50, 40, 90, 30, 60).dodajK(80)) );
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
