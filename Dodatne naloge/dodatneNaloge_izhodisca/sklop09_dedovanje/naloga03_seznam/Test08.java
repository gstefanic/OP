
import java.util.*;

public class Test08 {

    public static void main(String[] args) {
        System.out.println( s2l(s(-2, -3, -4, -5).uredi()) );
        System.out.println( s2l(s(-5, -4, -3, -2).uredi()) );
        System.out.println( s2l(s().uredi()) );
        System.out.println( s2l(s(10).uredi()) );
        System.out.println( s2l(s(10, 10, 10, 10).uredi()) );
        System.out.println( s2l(s(20, 50, 0, 20, 10, 60, 30).uredi()) );

        Seznam seznam = s();
        Random random = new Random(12345);
        for (int i = 0;  i < 30;  i++) {
            int r = random.nextInt(10);
            seznam = seznam.dodajZ(r);
        }
        System.out.println( s2l(seznam.uredi()) );
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
