
import java.util.Arrays;
import java.util.Scanner;

public class Dolgovi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stOseb = sc.nextInt();
        int stIzposoj = sc.nextInt();
        int[][] izposoje = new int[stOseb][stOseb];
        for (int i = 0; i < stIzposoj; i++) {
        	int osebaA = sc.nextInt();
        	int osebaB = sc.nextInt();
        	int izposoja = sc.nextInt();

        	izposoje[osebaA-1][osebaB-1] += izposoja;

        }

    	System.out.println(Arrays.deepToString(izposoje));
    	System.out.println(Arrays.deepToString(pobotaniDolgovi(izposoje)));


    }

    public static int[][] pobotaniDolgovi(int[][] izposoje){
    	int a = izposoje.length;
    	int b = izposoje[0].length;
    	int[][] pobotaniDolgovi = new int[a][b];
        for (int i = 0; i < a; i++) {
        	for (int j = 0; j < b; j++) {
        		int razlika = izposoje[i][j] - izposoje[j][i];

        		if (razlika < 0) {
        			pobotaniDolgovi[j][i] = -razlika;
        		}
        		else {
        			pobotaniDolgovi[i][j] = razlika;
        		}
        	}
        }
        return pobotaniDolgovi;
    }
}
