
import java.util.*;

public class Test06 {

    public static void main(String[] args) {
        System.out.println( s2l(s(-2, -3, -4, -5).odstrani(-2)) );
        System.out.println( s2l(s(-2, -3, -4, -5).odstrani(-3)) );
        System.out.println( s2l(s(-2, -3, -4, -5).odstrani(-4)) );
        System.out.println( s2l(s(-2, -3, -4, -5).odstrani(-5)) );
        System.out.println( s2l(s(-2, -3, -4, -5).odstrani(-6)) );

        System.out.println( s2l(s().odstrani(10)) );
        System.out.println( s2l(s(10).odstrani(10)) );
        System.out.println( s2l(s(10).odstrani(0)) );
        System.out.println( s2l(s(10, 10, 10, 10).odstrani(10)) );
        System.out.println( s2l(s(2, 3, 2, 3, 2, 3, 2, 3).odstrani(2)) );
        System.out.println( s2l(s(2, 3, 2, 3, 2, 3, 2, 3).odstrani(3)) );
        System.out.println( s2l(s(2, 3, 2, 3, 2, 3, 2, 3).odstrani(4)) );

        Seznam seznam = s(20, 10, 30, 40, 30, 30, 60);
        for (int i = 0;  i < 4;  i++) {
            seznam = seznam.odstrani(30);
            System.out.println(s2l(seznam));
        }
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
