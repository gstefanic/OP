import java.util.*;
public class DN02_01 {
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

		// definiraj polje celih števil
		// številke od 1 naprej, zaradi
		// problemov pri piramidnici zadadi
		// inicializacije praznih polj
		int tipkovnica[][]=null;

		if (oblikaTipkovnice==1) {
			// napolni polje kot ravnovrstnico
			tipkovnica = napolniRavnovrsticno(velikostTipkovnice);
		} else if (oblikaTipkovnice==2) {
			// napolni polje kot kvadratnico
			tipkovnica = napolniKvadratnico(velikostTipkovnice);
		} else if (oblikaTipkovnice==3) {
			// napolni polje kot piramidnico
			tipkovnica = napolniPiramidnico(velikostTipkovnice);
		} else {
			// napolni polje kot spiralnico
			tipkovnica = napolniSpiralnico(velikostTipkovnice);
		}

		//izpisiPolje(tipkovnica);

		// preberi tipke
		// najprej preveri ali ne bo pritisnil nobene tipke
		if (stVnesenihTipk>1) {
			// vnosu je potrebno pristeti 1, saj
			// smo tudi vsaki stevilki v polju pristeli 1
			int tipka1 = sc.nextInt()+1;
			int tipka2 = 0;

			for (int i = 1; i < stVnesenihTipk; i++) {
				if (i==1) {
					tipka2 = sc.nextInt()+1;
				}
				else {
					tipka1 = tipka2;
					tipka2 = sc.nextInt()+1;
				}
				//System.out.println(tipka1 + " " + tipka2);
				dolzinaPoti += razdalja(koordinate(tipkovnica, tipka1),
										koordinate(tipkovnica, tipka2));
			}
		}

		System.out.println(dolzinaPoti);

		long stopTime = System.currentTimeMillis();
      	long elapsedTime = stopTime - startTime;
      	//System.out.println(elapsedTime);
	}

	public static int[][] napolniRavnovrsticno(int velikostTipkovnice){
	    int tipkovnica[][] = new int[1][velikostTipkovnice];
	    for (int y = 0; y < velikostTipkovnice; y++){
	        tipkovnica[0][y] = y+1;
	    }
	    return tipkovnica;
	}

	public static int[][] napolniKvadratnico(int velikostTipkovnice){
		int tipkovnica[][] = new int[velikostTipkovnice][velikostTipkovnice];
		for (int y = 0; y < velikostTipkovnice; y++){
			for (int x = 0; x < velikostTipkovnice; x++){
				tipkovnica[x][y] = y*velikostTipkovnice+x+1;
			}
		}
	    return tipkovnica;
	}

	public static int[][] napolniPiramidnico(int velikostTipkovnice){
		int tipkovnica[][] = new int[2*velikostTipkovnice-1][velikostTipkovnice];
		int stevec = 1;
		for (int y = 0; y < velikostTipkovnice; y++){
			for (int x = 0; x < 2*y+1; x++){
				int stolpec = velikostTipkovnice-1-y+x;
				tipkovnica[stolpec][y] = stevec;
				stevec++;
			}
		}
	    return tipkovnica;
	}

	public static int[][] napolniSpiralnico(int velikostTipkovnice){
		int tipkovnica[][] = new int[velikostTipkovnice][velikostTipkovnice];
		int stKrogov = (velikostTipkovnice+1)/2;
		for (int krog = 0; krog<stKrogov; krog++) {
			int velikostKroga = velikostTipkovnice-(2*krog);
			int zacetnaSt = (velikostKroga-2)*(velikostKroga-2)+1;

			for (int x = 0; x < velikostKroga; x++) {
				tipkovnica[krog+x][krog+0] = zacetnaSt;
				zacetnaSt++;
			}

			for (int y = 1; y < velikostKroga; y++) {
				tipkovnica[velikostTipkovnice-krog-1][krog+y] = zacetnaSt;
				zacetnaSt++;
			}
		
			for (int x = velikostKroga-1-1; x >= 0; x--) {
				tipkovnica[krog+x][velikostTipkovnice-krog-1] = zacetnaSt;
				zacetnaSt++;
			}
			
			for (int y = velikostKroga-1; y > 1; y--) {
				tipkovnica[krog+0][krog+y-1] = zacetnaSt;
				zacetnaSt++;
			}

		}
		tipkovnica[(velikostTipkovnice+1)/2-1][(velikostTipkovnice+1)/2-1] = 1;
	    return tipkovnica;
	}

	public static int[] koordinate(int[][] polje, int stevilo){
		int[] koordinate = new int[2];
		for (int y = 0; y < polje[0].length; y++){
			for (int x = 0; x < polje.length; x++){
				if (polje[x][y]==stevilo) {
					koordinate[0] = x;
					koordinate[1] = y;
					return koordinate;
				}
			}
		}
		return koordinate;
	}

	public static int razdalja(int[] prvo, int[] drugo){
		int razdalja = abs(prvo[0]-drugo[0]) + abs(prvo[1]-drugo[1]);
		return razdalja;
	}

	public static void izpisiPolje(int[][] polje){
		for (int y = 0; y < polje[0].length; y++) {
			for (int x = 0; x < polje.length; x++) {
				System.out.print(polje[x][y] + "\t");
			}
			System.out.println("");
		}
	}

	public static int abs(int x){
		if (x<0) {
			return -x;
		} else {
			return x;
		}
	}

}