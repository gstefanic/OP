import java.util.*;
public class Zgoscenke {
    	public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		int n = sc.nextInt(), k = sc.nextInt();
    		int noviPodatki = 0, zasedeno = 0, zgoscenka = 1;
    			
			do {
				noviPodatki = sc.nextInt();
    			if ((zasedeno+noviPodatki)<=k) {
    				zasedeno+=noviPodatki;
    			}
    			else {
    				zgoscenka++;
    				if (zgoscenka > n) {
    					break;
    				}
    				zasedeno = noviPodatki;
    			}
				System.out.printf("%d EP -> zgoscenka %d (%d EP)%n", noviPodatki, zgoscenka, zasedeno);
    		
			}
    		while (sc.hasNextInt());
	}
}