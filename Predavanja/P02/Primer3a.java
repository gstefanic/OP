import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 1; i++) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c = sc.nextDouble();

            if (a+b>c && a+c>b && b+c>a) {

                double s = (a+b+c)/2;
                double p = Math.sqrt(s*(s-a)*(s-b)*(s-c));
                System.out.print("Ploščina trikotnika ABC je: " + p + ".");

            }
            else System.out.print("Napačni podatki.");
        }
    }
}