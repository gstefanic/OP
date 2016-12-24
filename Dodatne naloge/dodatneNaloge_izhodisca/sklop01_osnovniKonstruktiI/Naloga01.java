// tj.exe Naloga01.java naloga01_urejanjeTrojice naloga01_urejanjeTrojice
import java.util.*;

class Naloga01 {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] a = new int[3];
		a[0] = sc.nextInt(); 
		a[1] = sc.nextInt(); 
		a[2] = sc.nextInt();
		
		for (int j = 0; j < (a.length+1)/2; j++)
			for (int i = 0; i < a.length-1; i++) {
				
				if (a[i+1] < a[i]) {
					int tmp = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp;
				}
				
			}
		
		System.out.print(a[0]+ " " + a[1] + " " + a[2]);
		
		
		
	}
	
}
