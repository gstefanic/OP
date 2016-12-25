import java.util.*;
public class RomanRoma {
    	public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		int r = sc.nextInt(), d = sc.nextInt();
    		
    		do{
    			System.out.println(r);
    			r -= d;
    		}
    		while(r>0);
	}
}