import java.util.*;
public class Coll {
    	public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		int a = sc.nextInt(), b = sc.nextInt();
    		if (a>b) {
    			int tmp = a;
    			a = b;
    			b = tmp;
    		}

    		int max = 0, num = 0;

    		for (int i = a; i<=b; i++) {
				int k = stKorakov(i);
				if (max<k) {
					max = k;
					num = i;
				}
    		}

    		System.out.println(num + "\n" + max);
	}

	public static int stKorakov(int n){
	    	int korak = 1;

	    	while (n!=1) {
	    		if (n%2==0){
	    			n /= 2;
	    		}
	    		else {
	    			n = 3*n+1;
	    		}
	    		korak++;
	    	}

	    	return korak;
	}

}