
import java.util.Scanner;

public class Smreka {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
        	piramida(i, n-i-1);
        }
    }

    /*
     * Nariše piramido vi"sine <visina>, zamaknjeno za <zamik> presledkov v
     * desno.
     */
    private static void piramida(int visina, int zamik) {
    	// int sirina = 2*visina+1
    	for (int vrsticaVPiramidi = 0; vrsticaVPiramidi < visina; vrsticaVPiramidi++) {
			int stZvezdic = 2*vrsticaVPiramidi+1;
			int stZamikov = zamik + visina - vrsticaVPiramidi;

			for (int i = 0; i < stZamikov; i++) {
				System.out.print(" ");
			}

			for (int j = 0; j < stZvezdic; j++) {
				System.out.print("*");
			}
			System.out.println();
    	}
    }
}
