public class Testiraj {
	public static void main(String[] args) {
		Zp zp = new Zp(7);

		for (int j = 0; j < zp.vrniModul(); j++) {
			int osnova = j;
			
			for (int i = 0; i < zp.vrniModul(); i++) {
				System.out.println(osnova + "^" + i + " = " + zp.potenca(osnova,i));
			}

			System.out.println();
		}

		//System.out.println(zp.steviloKvadratnihKorenov(1));

	}
}