// tj.exe Naloga04.java naloga04_postevankaII naloga04_postevankaII
import java.util.*;

class Naloga04 {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(), b = sc.nextInt();
		
		int i = 1;
		while ((a*i)<=b) {
			
			System.out.println(a + " * " + i + " = " + (a*i));
			
			i++;
		}
		
		
		
	}
	
}