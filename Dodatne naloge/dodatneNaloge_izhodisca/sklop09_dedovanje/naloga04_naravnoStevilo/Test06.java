
import java.util.*;

public class Test06 {

    public static void main(String[] args) {
        System.out.println( s2i(s(1).zmnozek(s(1))) );
        System.out.println( s2i(s(1).zmnozek(s(5))) );
        System.out.println( s2i(s(1).zmnozek(s(10))) );
        System.out.println( s2i(s(1).zmnozek(s(100))) );
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
