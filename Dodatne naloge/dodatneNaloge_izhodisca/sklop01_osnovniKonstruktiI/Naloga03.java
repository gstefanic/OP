// tj.exe Naloga03.java naloga03_postevankaI naloga03_postevankaI
import java.util.*;

class Naloga03 {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(), b = sc.nextInt();
		
		for (int i = 1; i <= b; i++) {
			
			System.out.println(a + " * " + i + " = " + (a*i));
			
		}
		
		
		
	}
	
}