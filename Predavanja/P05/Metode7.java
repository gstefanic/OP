class Metode7 {
	public static long fak(int n) {
		if (n==1) {
			return 1;
		}
		else {
			return n * fak(n-1);
		}
	}
	
	public static long fakIterativno(int n) {
		long produkt = 1;
		for (int i = 2; i<=n; i++) {
			produkt *= i;
		}
		return produkt;
	}
	
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%4d %15d %15d %n", i, fak(i), fakIterativno(i));
		}
	}
	
}