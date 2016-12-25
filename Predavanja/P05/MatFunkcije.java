class MatFunkcije {
	// meja natančnosti
	private static double eps = 1e-5; //deklarirana na ravni razreda - globalna spremenljivka
	public static final double PI = 3.141592653589793;

	public static double abs(double x) {
		//  if (x>=0) return x; else return -x;
		return x>=0 ? x : -x;
	}

	public static double exp(double x) {
		int n = 0; // lokalna spremenljivka - dostopne samo znotraj metode
		double clen = 1, vsota = 1;
		while (abs(clen)>=eps) {
			n++;
			clen *= x/n;
			vsota += clen;
		}
		return vsota;
	}
	
	// člene prištevamo v zanki, naslednji člen izračunamo iz prejšnjega
	// pri izračunu imenovalca si pomagamo s pomožno spremenljivko k
	public static double sin(double x) {
		int k = 1;
		double clen = x, vsota = x;
		
		while(abs(clen)>=eps) {
			k+=2;
			clen=-clen*x*x/(k*(k-1));
			vsota+=clen;
		}
		return vsota;
	}
	
	public static double cos(double x) {
		int k = 0;
		double clen = 1, vsota = 1;
		while(abs(clen)>=eps) {
			k+=2;
			clen=-clen*x*x/(k*(k-1));
			vsota+=clen;
		}
		return vsota;
	}
	
}
