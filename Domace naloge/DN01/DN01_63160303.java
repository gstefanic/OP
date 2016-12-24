import java.util.*;
class DN01_63160303 {
	public static void main(String[] args) {
		int k = 0; // število kock
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		if (t == 1) { // 1: kocka
			int a = sc.nextInt();
			k = a*a*a;
		} else if (t == 2) { // 2: kvader
			int a = sc.nextInt(),
				b = sc.nextInt(),
				c = sc.nextInt();
			k = a*b*c;
		} else if (t == 3) { // 3: piramida
			int a = sc.nextInt();
			for (int i = 1; i <= a; i++) {
				k += (i*i);
			}
		} else if (t == 4) { // 4: prizma
			int a = sc.nextInt(),
				b = sc.nextInt();
			k = a*(a+1)/2*b;
		} else if (t == 5) { // 5: votla piramida
			int a = sc.nextInt();
			for (int i = 1; i <= a; i++) {
				k += (i*i);
				if (i >= 3) {
					k -= (i-2)*(i-2);
				}
			}
		} else if (t == 6){ // 6: votla prizma
			int a = sc.nextInt(),
				b = sc.nextInt();
			k = 2*a*(a+1)/2+(b-2)*(2*a-1);
		}
		
		System.out.println(k);
	}
}