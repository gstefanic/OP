
import java.util.*;

public class Test03 {

    public static void main(String[] args) {
        System.out.println( s2i(s(5).vsota(s(1))) );
        System.out.println( s2i(s(5).vsota(s(5))) );
        System.out.println( s2i(s(3).vsota(s(4))) );
        System.out.println( s2i(s(4).vsota(s(3))) );
        System.out.println( s2i(s(42).vsota(s(75))) );
        System.out.println( s2i(s(75).vsota(s(42))) );
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
