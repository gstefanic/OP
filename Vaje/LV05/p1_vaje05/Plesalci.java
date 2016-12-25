
import java.util.Scanner;

public class Plesalci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stMoskih = sc.nextInt(),
            stZensk = sc.nextInt(),
            gcd = sc. nextInt(),
            par = 1;

        for (int i = gcd; i <= stMoskih; i+=gcd) {
            for (int j = gcd; j <= stZensk; j+=gcd) {
                if (gcd(i,j)==gcd) {
                    System.out.printf("[%d] %d + %d%n", par, i, j);
                    par++;
                }
            }
        }

    }

    /*
     * Vrne GCD pozitivnih celih števil a in b.
     */
    public static int gcd(int a, int b) {
        while (b > 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}
