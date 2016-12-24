
import java.util.*;

public class Test10 {

    public static void main(String[] args) {
        System.out.println( NaravnoStevilo.ustvariIzInt(1).toString() );
        System.out.println( NaravnoStevilo.ustvariIzInt(2).toString() );
        System.out.println( NaravnoStevilo.ustvariIzInt(5).toString() );
        System.out.println( NaravnoStevilo.ustvariIzInt(10).toString() );
        System.out.println( NaravnoStevilo.ustvariIzInt(42).toString() );
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
