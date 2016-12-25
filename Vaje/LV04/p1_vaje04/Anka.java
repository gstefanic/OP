import java.util.*;
public class Anka {
    	public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
		    int m = sc.nextInt(), d = sc.nextInt();
		    int k=0;
		    for (int a = 1; a <= 9; a+=2){
		    	for (int b = m+1; b <= 9; b++){
		    	    for (int c = 0; c <= 9; c++){
		    	        if (c%d==0) {
		    	        	System.out.printf("%d-%d-%d%n", a, b, c);
		    	        	k++;
		    	        }
		    	    }
		    	}

		    }
		    System.out.print(k);
	}
}