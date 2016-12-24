// tj.exe Naloga01.java naloga01_delitelji naloga01_delitelji
import java.util.*;

class Naloga01 {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		for (int i = 1; i<=(a/2); i++) {
			
			if(a%i==0)
				System.out.println(i);
			
		}
		System.out.println(a);
			
		
	}
	
}