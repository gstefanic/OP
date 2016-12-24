
import java.util.*;

public class Test07 {

    public static void main(String[] args) {
        Seznam seznam = s();
        Random random = new Random(12345);

        for (int i = 0;  i < 100;  i++) {
            double r = random.nextDouble();
            if (r < 0.17) {
                seznam = seznam.odstrani(0);
            } else if (r < 0.33) {
                seznam = seznam.odstrani(1);
            } else if (r < 0.50) {
                seznam = seznam.dodajZ(0);
            } else if (r < 0.67) {
                seznam = seznam.dodajZ(1);
            } else if (r < 0.83) {
                seznam = seznam.dodajK(0);
            } else {
                seznam = seznam.dodajK(1);
            }
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
