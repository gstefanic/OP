import java.util.*;
public class Razdalje {
	static Scanner sc = new Scanner(System.in);
    static final int ST_TOCK = sc.nextInt();
    static double[] x = new double[ST_TOCK];
    static double[] y = new double[ST_TOCK];
    static double[][] r = new double[ST_TOCK][ST_TOCK];

    public static void main(String[] args) {
    	preberiPodatke();
    	izracunajRazdalje();
    	izpisiRezultate();
    }

    private static void preberiPodatke() {
    	//Scanner sc = new Scanner(System.in);

    	for (int i = 0; i<ST_TOCK; i++) {
    		System.out.print("Koordinata x "+(i+1)+". tocke: ");
    		x[i] = sc.nextDouble();
    		System.out.print("Koordinata y "+(i+1)+". tocke: ");
    		y[i] = sc.nextDouble();
    	}
    }

    private static void izracunajRazdalje() {
    	for (int i = 0; i < ST_TOCK; i++) {
    		// gremo samo diagonale
    		for (int j = 0; j<=i; j++) {
    			if (i==j) {
    				// ni treba uporabiti pitagorovega izreka
    				r[i][j] = 0;
    			}
    			else {
    				double dx = x[i] - x[j];
    				double dy = y[i] - y[j];
    				r[i][j] = Math.sqrt(dx*dx+dy*dy);
    				r[j][i] = r[i][j];
    			}
    		}
    	}
    }

    private static void izpisiRezultate() {
    	for (double[] el1 : r) {
    		for (double el : el1) {
    			System.out.printf("%6.2f", el);
    		}
    		System.out.println();
    	}
    }

}