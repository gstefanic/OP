import java.util.*;
class Primer1a {
	
	public static void main(String[] args) {
		
		double a, b, c, s, p;
		
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextDouble();
		b = sc.nextDouble();
		c = sc.nextDouble();
		
		s = (a+b+c)/2;
		p = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		
		System.out.println("" + p);
		
	}
	
}