class Metode9 {
	public static int fib(int n) {
		if (n<=1) {
			return n;
		}
		else {
			return fib(n-1) + fib(n-2);
		}
	}
	
	public static int fibIterativno(int n) {
		if (n<=1) {
			return n;
		}
		int x = 1, y = 0;
		for (int i = 2; i <= n; i++) {
			int tmp = x;
			x = x+y;
			y = tmp;
		}
		return x;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			System.out.printf("%2d %6d %6d %n", i, fib(i), fibIterativno(i));
		}
	}
	
}