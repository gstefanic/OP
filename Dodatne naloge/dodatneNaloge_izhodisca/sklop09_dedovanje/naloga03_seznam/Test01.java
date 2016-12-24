
import java.util.*;

public class Test01 {

    public static void main(String[] args) {
        System.out.println( s(-2, -3, -4, -5).glava() );
        System.out.println( s(3, 5, 6).glava() );
        System.out.println( s(42, -10).glava() );
        System.out.println( s(30).glava() );
        try {
            System.out.println( s().glava() );
        } catch (NoSuchElementException ex) {
            System.out.println("Izjema!");
        }
        System.out.println("----------");

        System.out.println( s2l(s(-2, -3, -4, -5).rep()) );
        System.out.println( s2l(s(3, 5, 6).rep()) );
        System.out.println( s2l(s(42, -10).rep()) );
        System.out.println( s2l(s(30).rep()) );
        try {
            System.out.println( s2l(s().rep()) );
        } catch (NoSuchElementException ex) {
            System.out.println("Izjema!");
        }
        System.out.println("----------");

        System.out.println( s(-2, -3, -4, -5).jePrazen() );
        System.out.println( s(3, 5, 6).jePrazen() );
        System.out.println( s(42, -10).jePrazen() );
        System.out.println( s(30).jePrazen() );
        System.out.println( s().jePrazen() );
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
