// tj.exe Naloga05.java naloga05_potenca naloga05_potenca
import java.util.*;

class Naloga05 {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(), b = sc.nextInt();
		
		int i = 1;
		int r = 1;
		while (i<=b) {
			
			r*=a;
			
			i++;
		}
		
		System.out.println(r);
		
		
	}
	
}