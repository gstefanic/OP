import java.util.*;
class Metode8 {
	public static long gcd(int a, int b) {
		if (a%b==0) {
			return b;
		}
		else {
			return gcd(b,a%b);
		}
	}
	
	public static long gcdIterativno(int a, int b) {
		while (a%b!=0) {
			int tmp = a;
			a=b;
			b=tmp%b;
		}
		return b;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		if (a<b) {
			int tmp = a;
			a=b;
			b=tmp;
		}
		
		System.out.print(gcd(a,b));
		
	}
	
}