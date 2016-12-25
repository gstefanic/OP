import java.util.*;
public class RomanRomaIII {
    	public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		int r = sc.nextInt(), d = sc.nextInt(), m = sc.nextInt();
            int dan = 1, p = d;
    		
    		do{
                if (r<d) {
                    p = r;
                }
                else {
                    p = d;
                }
                System.out.printf("%d. dan: %d -> %d (prehodil %d)%n", dan, r, (r-p), p);
                r -= d;
                dan++;
                d -= m;

    		}
    		while(r>0 && d>0);
	}
}