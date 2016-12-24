
import java.util.*;

public class Test01 {

    public static void main(String[] args) {
        System.out.println( s(1).jeEna() );
        System.out.println( s(5).jeEna() );
        System.out.println( s(42).jeEna() );

        System.out.println( s2i(s(1).naslednik()) );
        System.out.println( s2i(s(5).naslednik()) );
        System.out.println( s2i(s(42).naslednik()) );

        try {
            System.out.println( s2i(s(1).predhodnik()) );
        } catch (NoSuchElementException ex) {
            System.out.println("Izjema!");
        }
        System.out.println( s2i(s(5).predhodnik()) );
        System.out.println( s2i(s(42).predhodnik()) );
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
