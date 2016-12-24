
import java.util.*;

public class Test09 {

    public static void main(String[] args) {
        int n = 1000;
        Filozof[] ff = new Filozof[n];
        for (int i = 0;  i < n;  i++) {
            ff[i] = new Filozof();
        }
        for (int i = 0;  i < n;  i++) {
            ff[i].nastaviSoseda(ff[(n + i - 1) % n], ff[(i + 1) % n]);
        }

        System.out.println(ff[0].steviloFilozofov());
        System.out.println(ff[123].steviloFilozofov());
        System.out.println(ff[765].steviloFilozofov());
        System.out.println(ff[999].steviloFilozofov());
    }
}
