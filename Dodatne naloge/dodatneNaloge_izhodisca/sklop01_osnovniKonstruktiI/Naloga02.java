// tj.exe Naloga02.java naloga02_zaporedja naloga02_zaporedja
import java.util.*;

class Naloga02 {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(), b = sc.nextInt(), k = sc.nextInt();
		
		if (k!=0) {
			
			if (a<=b && k>0) {
				
				do {
					System.out.println(a);
					a+=k;
				}while(a<=b);
				
			}
			else if (a>=b && k<0) {
				
				do {
					
					System.out.println(a);
					a+=k;
					
				}while(a>=b);
				
			}
			else {
				
				System.out.println("NAPAKA");
				
			}
			
		}
		else {
			
			System.out.println("NAPAKA");
			
		}
		
		
	}
	
}