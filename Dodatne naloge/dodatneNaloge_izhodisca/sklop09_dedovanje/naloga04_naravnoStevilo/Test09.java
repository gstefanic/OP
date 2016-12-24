
import java.util.*;

public class Test09 {

    public static void main(String[] args) {
        System.out.println( s(1).toInt() );
        System.out.println( s(2).toInt() );
        System.out.println( s(5).toInt() );
        System.out.println( s(10).toInt() );
        System.out.println( s(42).toInt() );
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
