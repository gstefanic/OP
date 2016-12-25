
import java.util.Scanner;

public class VrstaZbor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stVojakov = sc.nextInt();

        // preberi višine vojakov
        int[] visine = new int[stVojakov];
        for (int i = 0;  i < stVojakov;  i++) {
            visine[i] = sc.nextInt();
        }

        int stevec = 0;

        for (int i = 0; i < stVojakov; i++) {
        	if (i > 0 && i < visine.length-1) {
        		if (visine[i-1]<=visine[i] && visine[i+1]>=visine[i]) {
        			System.out.println(i);
        			stevec++;
        		}
        	}
        	else if (i==0) {
        		if (visine[i+1]>=visine[i]) {
        			System.out.println(i);
        			stevec++;
        		}
        	} else {
        		if (visine[i-1]<=visine[i]) {
        			System.out.println(i);
        			stevec++;
        		}
        	}
        }

        if (stevec == 0) {
        	System.out.println("NOBEDEN");
        }

    }
}
