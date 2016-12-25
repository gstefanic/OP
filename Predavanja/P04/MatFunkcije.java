class MatFunkcije {
	// meja natančnosti
	private static double eps = 1e-5;

	public static double abs(double x) {
		//  if (x>=0) return x; else return -x;
		return x>=0 ? x : -x;
	}

	public static double exp(double x) {
		int n = 0;
		double clen = 1, vsota = 1;
		while (abs(clen)>=eps) {
			n++;
			clen *= x/n;
			vsota += clen;
		}
		return vsota;
	}
}
