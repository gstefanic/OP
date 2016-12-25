class Metode6b {
	public static void main(String[] args) {
		for (int kot = 0; kot<=360; kot+=30) {
			double x = MatFunkcije.PI/180*kot;
			System.out.printf("%3d %8.5f %8.5f %8.5f %8.5f %n", kot, MatFunkcije.sin(x), Math.sin(x), MatFunkcije.cos(x), Math.cos(x));
		}
	}
}