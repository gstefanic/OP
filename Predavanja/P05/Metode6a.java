class Metode6a {
	public static void main(String[] args) {
		for (int i = -20; i<=20; i++) {
			double x=i/10.; // pika na koncu poskrbi, da ne dobimo celega števila
			System.out.printf("%5.2f %10.5f %10.5f %n",x, MatFunkcije.exp(x), Math.exp(x));
		}
	}
}