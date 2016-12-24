import java.util.*;
public class DN02_63160303 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		Scanner sc = new Scanner(System.in);

		int dolzinaPoti = 0;

		// preberi obliko tipkovnice
		// 1 - ravnovrstica, 2 - kvadratnica
		// 3 - piramidnica, 4 - spiralnica
		int oblikaTipkovnice = sc.nextInt(),
			velikostTipkovnice = sc.nextInt(),
			stVnesenihTipk = sc.nextInt();

		// preberi tipke
		// najprej preveri ali ne bo pritisnil nobene tipke
		if (stVnesenihTipk>1) {
			// vnosu je potrebno pristeti 1, saj
			// smo tudi vsaki stevilki v polju pristeli 1
			int tipka1 = sc.nextInt();
			int tipka2 = 0;

			for (int i = 1; i < stVnesenihTipk; i++) {
				if (i==1) {
					tipka2 = sc.nextInt();

				}
				else {
					tipka1 = tipka2;
					tipka2 = sc.nextInt();
				}
				//System.out.println(tipka1 + " " + tipka2);
				dolzinaPoti += razdalja(vrniX(oblikaTipkovnice, tipka1, velikostTipkovnice),
										vrniY(oblikaTipkovnice, tipka1, velikostTipkovnice),
										vrniX(oblikaTipkovnice, tipka2, velikostTipkovnice),
										vrniY(oblikaTipkovnice, tipka2, velikostTipkovnice));
			}
		}

		System.out.println(dolzinaPoti);

		long stopTime = System.currentTimeMillis();
      	long elapsedTime = stopTime - startTime;
      	//System.out.println(elapsedTime);
	}


	public static int razdalja(int x1, int y1, int x2, int y2){
		int razdalja = abs(x1-x2) + abs(y1-y2);
		return razdalja;
	}

	public static int abs(int x){
		if (x<0) {
			return -x;
		} else {
			return x;
		}
	}

	// Krajši zapis
	public static int vrniX(int vrstaTipkovnice, int tipka, int velikostTipkovnice) {
		int x = 0;
		if (vrstaTipkovnice==1) {
			// ravnovrsticna
			x = tipka;
		} else if (vrstaTipkovnice==2) {
			// kvadratnica
			x = tipka%velikostTipkovnice;
		} else if (vrstaTipkovnice==3) {
			// piramidnica
			int vrstica = (int)Math.sqrt(tipka);
			int stolpec = tipka - vrstica*vrstica + velikostTipkovnice-1 - vrstica;
			x = stolpec;
		} else {
			// spiralnica
			if (tipka==0) {
				return (velikostTipkovnice-1)/2;
			}
			int krog = ((int)Math.sqrt(tipka)+1)/2;
			int velikostKroga = 2*krog+1;
			int zacetnaSt = (velikostKroga-2)*(velikostKroga-2);
			int zapStVKrogu = tipka-zacetnaSt;
			int stranica = zapStVKrogu/(velikostKroga-1);
			int zapStNaStranici = zapStVKrogu%(velikostKroga-1);

			if (stranica==0) {
				x = (velikostTipkovnice-velikostKroga)/2 + zapStNaStranici;
			} else if (stranica==1) {
				x = (velikostTipkovnice-velikostKroga)/2 + 
								(velikostKroga-1);
			} else if (stranica==2) {
				x = (velikostTipkovnice-velikostKroga)/2 + 
								(velikostKroga-1) - zapStNaStranici;
			} else {
				x = (velikostTipkovnice-velikostKroga)/2;
			}
		}
		return x;
	}

	public static int vrniY(int vrstaTipkovnice, int tipka, int velikostTipkovnice) {
		int y = 0;
		if (vrstaTipkovnice==1) {
			// ravnovrstina
			y = 0;
		} else if (vrstaTipkovnice==2) {
			// kvadratnica
			y = tipka/velikostTipkovnice;
		} else if (vrstaTipkovnice==3) {
			// piramidnica
			int vrstica = (int)Math.sqrt(tipka);
			y = vrstica;
		} else {
			if (tipka==0) {
				return (velikostTipkovnice-1)/2;
			}
			// spiralnica
			int krog = ((int)Math.sqrt(tipka)+1)/2;
			int velikostKroga = 2*krog+1;
			int zacetnaSt = (velikostKroga-2)*(velikostKroga-2);
			int zapStVKrogu = tipka-zacetnaSt;
			int stranica = zapStVKrogu/(velikostKroga-1);
			int zapStNaStranici = zapStVKrogu%(velikostKroga-1);

			if (stranica==0) {
				y = (velikostTipkovnice-velikostKroga)/2;
			} else if (stranica==1) {
				y = (velikostTipkovnice-velikostKroga)/2 +
								zapStNaStranici;
			} else if (stranica==2) {
				y = (velikostTipkovnice-velikostKroga)/2 +
								(velikostKroga-1);
			} else {
				y = (velikostTipkovnice-velikostKroga)/2 +
								(velikostKroga-1) - zapStNaStranici;
			}
		}
		return y;
	}

}