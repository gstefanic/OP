
import java.util.Scanner;
import java.util.Random;

public class Dvoboj {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int seme = sc.nextInt(),
        	stPartij = sc.nextInt(),
        	verjetnostA = sc.nextInt(),
        	verjetnostB = sc.nextInt();

    	int zmageA = 0,
    		zmageB = 0,
    		zmage = 0;

        Random r = new Random(seme);

    	while (zmageA < stPartij && zmageB < stPartij) {

    		int nak = r.nextInt(100);
    		if (nak < verjetnostA) {
    			zmageA++;
    			System.out.print("A");
    		}
    		else if (nak > (verjetnostA) && nak < (verjetnostA+verjetnostB)) {
    			zmageB++;
    			System.out.print("B");
    		} else {
    			System.out.print("-");
    		}
    	}System.out.println();


    }
}
