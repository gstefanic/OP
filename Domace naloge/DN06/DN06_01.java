import java.util.*;
public class DN06_63160303 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		Scanner sc = new Scanner(System.in);
		int stVrstic = sc.nextInt();
		int stStolpcev = sc.nextInt();

		int[][] plevel = new int[stVrstic][stStolpcev];
		for (int i = 0; i < stVrstic; i++) {
			for (int j = 0; j < stStolpcev; j++) {
				plevel[i][j] = sc.nextInt();
			}
		}

		// koliko levo
		int[][] kolikoLevo = new int[stVrstic][stStolpcev];

		for (int i = 0; i < stVrstic; i++) {
			kolikoLevo[i][0] = plevel[i][0];
			for (int j = 1;	j < stStolpcev; j++) {
				kolikoLevo[i][j] = plevel[i][j]*(kolikoLevo[i][j-1] + 1);
			}
		}

		// koliko desno
		int[][] kolikoDesno = new int[stVrstic][stStolpcev];

		for (int i = stVrstic-1; i >= 0; i--) {
			kolikoDesno[i][stStolpcev-1] = plevel[i][stStolpcev-1];
			for (int j = stStolpcev-2; j >= 0; j--) {
				kolikoDesno[i][j] = plevel[i][j]*(kolikoDesno[i][j+1] + 1);
			}
		}

		/*izpisi(kolikoDesno);

		System.out.println();

		izpisi(kolikoLevo);*/

		int stOgraj=0;

		for (int vrstica = 0; vrstica < stVrstic; vrstica++) {
			for (int stolpec = 0; stolpec < stStolpcev; stolpec++) {
				if (plevel[vrstica][stolpec] == 1) {
					int visina = 1;
					int sirina = kolikoDesno[vrstica][stolpec];
					int najboljLevo = stolpec;
					int tmpVrstica = vrstica;
					int tmpStolpec = stolpec + kjeJePlevel(plevel, vrstica, najboljLevo, sirina, stolpec);
					//System.out.println("vr: " + tmpVrstica + " st: " + tmpStolpec + " nl: " + najboljLevo);

					tmpVrstica++;
					while ((tmpVrstica) < stVrstic && (plevel[tmpVrstica][tmpStolpec] == 1)) {

						int izracunNaLevo = (tmpStolpec - (kolikoLevo[tmpVrstica][tmpStolpec] - 1));
						if (izracunNaLevo < najboljLevo) {
							najboljLevo = izracunNaLevo;
						}

						if (kolikoDesno[tmpVrstica][izracunNaLevo] > sirina) {
							sirina = kolikoDesno[tmpVrstica][izracunNaLevo];
						}
						
						//System.out.println("vr: " + tmpVrstica + " st: " + tmpStolpec + " nl: " + najboljLevo);
						tmpStolpec += kjeJePlevel(plevel, tmpVrstica, najboljLevo, sirina, tmpStolpec);

						visina++;
						tmpVrstica++;
					}

					plevel = pocistiPolje(plevel, vrstica, najboljLevo, visina, sirina);
					kolikoDesno = pocistiPolje(kolikoDesno, vrstica, najboljLevo, visina, sirina);
					kolikoLevo = pocistiPolje(kolikoLevo, vrstica, najboljLevo, visina, sirina);

					//System.out.println("vi: " + visina + " si: " + sirina + "\n");

					stOgraj += 2*(visina + sirina);

				}
			}
		}

		System.out.println(stOgraj);

		long stopTime = System.currentTimeMillis();
      	long elapsedTime = stopTime - startTime;
      	System.out.println(elapsedTime);
	}

	public static int kjeJePlevel(int[][] tabela, int vrstica, int zacStolpec, int sirina, int tmpStolpec) {
		for (int i = zacStolpec; i < (zacStolpec + sirina); i++) {
			if ((vrstica + 1) < tabela.length && tabela[vrstica + 1][i] == 1 && tabela[vrstica][i] == 1) {
				//System.out.println("kje je: " + i + " vrstica: " + (vrstica + 1) + " najboljLevo: " + zacStolpec
				//	+ " sirina: " + sirina + " visina: " + visina);
				//System.out.println("naprej za: " + (i - zacStolpec));
				return i - tmpStolpec;
			}
		}

		return 0;
	}

	public static void izpisi(int[][] tabela) {
		String out = "";
		for (int i = 0; i < tabela.length; i++) {
			for (int j = 0; j < tabela[i].length; j++) {
				out += tabela[i][j] + " ";
			}
			out += "\n";
		}
		System.out.print(out);
	}

	public static int[][] pocistiPolje(int[][] tabela, int zacVrstica, int zacStolpec, int visina, int sirina) {
		for (int i = zacVrstica; i < (zacVrstica + visina); i++) {
			for (int j = zacStolpec; j < (zacStolpec + sirina); j++) {
				tabela[i][j] = 0;
			}
		}
		return tabela;
	}

}