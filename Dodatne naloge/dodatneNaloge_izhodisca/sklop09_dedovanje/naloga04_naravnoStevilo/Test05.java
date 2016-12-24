
import java.util.*;

public class Test05 {

    public static void main(String[] args) {
        try {
            System.out.println( s2i(s(1).razlika(s(1))) );
        } catch (NoSuchElementException ex) {
            System.out.println("Izjema!");
        }

        try {
            System.out.println( s2i(s(1).razlika(s(5))) );
        } catch (NoSuchElementException ex) {
            System.out.println("Izjema!");
        }

        System.out.println( s2i(s(10).razlika(s(2))) );
        System.out.println( s2i(s(10).razlika(s(3))) );
        System.out.println( s2i(s(10).razlika(s(9))) );

        System.out.println( s2i(s(42).razlika(s(27))) );

        try {
            System.out.println( s2i(s(42).razlika(s(42))) );
        } catch (NoSuchElementException ex) {
            System.out.println("Izjema!");
        }

        try {
            System.out.println( s2i(s(27).razlika(s(42))) );
        } catch (NoSuchElementException ex) {
            System.out.println("Izjema!");
        }
    }

    private static NaravnoStevilo s(int n) {
        if (n == 1) {
            return new Ena();
        }
        return new Naslednik(s(n - 1));
    }

    private static int s2i(NaravnoStevilo s) {
        if (s.jeEna()) {
            return 1;
        }
        return s2i(s.predhodnik()) + 1;
    }
}
