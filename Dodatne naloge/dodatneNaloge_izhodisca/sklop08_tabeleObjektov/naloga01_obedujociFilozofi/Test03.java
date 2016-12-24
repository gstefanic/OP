
import java.util.*;

public class Test03 {

    public static void main(String[] args) {
        int n = 3;
        Filozof[] ff = new Filozof[n];
        for (int i = 0;  i < n;  i++) {
            ff[i] = new Filozof();
        }
        for (int i = 0;  i < n;  i++) {
            ff[i].nastaviSoseda(ff[(n + i - 1) % n], ff[(i + 1) % n]);
        }

        Random random = new Random(12345);
        for (int i = 1;  i < 10;  i++) {
            int ixFilozof = random.nextInt(n);
            Filozof f = ff[ixFilozof];
            int r = random.nextInt(100);

            if (r < 25) {
                System.out.printf("ff[%d].primiLevo()%n", ixFilozof);
                f.primiLevo();

            } else if (r < 50) {
                System.out.printf("ff[%d].primiDesno()%n", ixFilozof);
                f.primiDesno();

            } else if (r < 75) {
                System.out.printf("ff[%d].izpustiLevo()%n", ixFilozof);
                f.izpustiLevo();

            } else {
                System.out.printf("ff[%d].izpustiDesno()%n", ixFilozof);
                f.izpustiDesno();
            }
            izpisiStanje(ff);
            System.out.println("----------");
        }
    }

    private static void izpisiStanje(Filozof[] ff) {
        int[] palicice = new int[ff.length];
        for (int i = 0;  i < ff.length;  i++) {
            palicice[i] = ff[i].kolikoPalicicDrzi();
        }
        System.out.println(Arrays.toString(palicice));
    }
}
