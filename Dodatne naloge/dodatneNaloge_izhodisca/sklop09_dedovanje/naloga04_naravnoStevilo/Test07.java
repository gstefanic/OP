
import java.util.*;

public class Test07 {

    public static void main(String[] args) {
        System.out.println( s2i(s(7).zmnozek(s(1))) );
        System.out.println( s2i(s(7).zmnozek(s(5))) );
        System.out.println( s2i(s(5).zmnozek(s(7))) );
        System.out.println( s2i(s(25).zmnozek(s(12))) );
        System.out.println( s2i(s(12).zmnozek(s(25))) );
        System.out.println( s2i( s(5).vsota(s(7)).razlika(s(9)).zmnozek( s(5).vsota(s(4)).razlika(s(3)) ) ) );
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
