// 63160303

public class Urnik {
    int[][] urnik;
    int[][] ureDoKoncaBloka;

    public Urnik() {
    	this.urnik = new int[24][5];
    	this.ureDoKoncaBloka = new int[24][5];
    }

    public boolean dodajBlok(int predmet, int dan, int zacetnaUra, int trajanje) {
    	int[][] tmpUrnik = new int[24][5];
    	for (int i = 0; i < 24; i++) {
 			for (int j = 0; j < 5; j++) {
 				tmpUrnik[i][j] = this.urnik[i][j];
 			}
 		}

    	for (int i = zacetnaUra; i < (zacetnaUra + trajanje); i++) {
    		if (this.urnik[i][dan - 1] != 0) {
    			return false;
    		}
    		tmpUrnik[i][dan - 1] = predmet;
    	}

    	for (int i = 0; i < 24; i++) {
 			for (int j = 0; j < 5; j++) {
 				this.urnik[i][j] = tmpUrnik[i][j];
 			}
 		}

 		int stUrDoKonca = trajanje;

 		this.ureDoKoncaBloka[zacetnaUra][dan - 1] = trajanje;

 		/*for (int i = zacetnaUra; i < (zacetnaUra + trajanje); i++) {
 			this.ureDoKoncaBloka[i][dan - 1] = stUrDoKonca;
 			stUrDoKonca--;
 		}*/

    	return true;
 	}

 	public void odstraniPredmet(int predmet) {
 		for (int i = 0; i < 24; i++) {
 			for (int j = 0; j < 5; j++) {
 				if (this.urnik[i][j] == predmet) {
 					this.urnik[i][j] = 0;
 					this.ureDoKoncaBloka[i][j] = 0;
 				}
 			}
 		}
 	}

 	public int kaj(int dan, int ura) {
 		return this.urnik[ura][dan - 1];
 	}

 	public int steviloUr(int predmet)  {
 		int steviloUr = 0;
 		for (int i = 0; i < 24; i++) {
 			for (int j = 0; j < 5; j++) {
 				if (this.urnik[i][j] == predmet) {
 					steviloUr++;
 				}
 			}
 		}
 		return steviloUr;
 	}

 	public int najPredmet() {
 		int maxStUr = 0;
 		int maxPredmet = 0;

 		for (int i = 0; i < 24; i++) {
 			for (int j = 0; j < 5; j++) {
 				if (this.urnik[i][j] != 0) {
 					int tmpPredmet = this.urnik[i][j];

 					if (steviloUr(tmpPredmet) > maxStUr) {
 						maxPredmet = tmpPredmet;
 					}

 				}
 			}
 		}

 		return maxPredmet;
 	}

 	public int vrzeli(int dan) {
 		int vrzeli = 0;
 		int zacetekDneva = 0;
 		int konecDneva = 0;
 		for (int i = 7; i < 24; i++) {
 			if (this.urnik[i][dan - 1] != 0) {
 				zacetekDneva = i;
 				break;
 			}
 		}

 		for (int i = 23; i >= 7; i--) {
 			if (this.urnik[i][dan - 1] != 0) {
 				konecDneva = i;
 				break;
 			}
 		}

 		for (int i = zacetekDneva; i <= konecDneva; i++) {
 			if (this.urnik[i][dan - 1] == 0) {
 				vrzeli++;
 			}
 		}

 		return vrzeli;
 	}

 	public void strni() {
 		int[][] novUrnik = new int[24][5];
 		int[][] noveUreDoKonca = new int[24][5];
 		int dan = 0;
 		int ura = 7;
 		int predmet = 0;

 		for (int j = 0; j < 5; j++) {
 			for (int i = 7; i <= 18; i++) {
 				int trajanjeBloka = ureDoKoncaBloka[i][j];
 				if (ureDoKoncaBloka[i][j] != 0) {
 					predmet = urnik[i][j];
 					if (!lahkoNovPredmet(novUrnik, dan, ura, trajanjeBloka)) {
 						dan++;
 						ura = 7;
 					}

 					noveUreDoKonca[ura][dan] = trajanjeBloka;
 					for (int k = 0; k < trajanjeBloka; k++) {
 						novUrnik[ura][dan] = predmet;
 						ura++;
 					}
 				}
 			}
 		}

 		this.ureDoKoncaBloka = noveUreDoKonca;
 		this.urnik = novUrnik;
 	}

 	public boolean lahkoNovPredmet(int[][] novUrnik, int dan, int ura, int trajanjeBloka) {
 		if (ura < 19 && (ura + trajanjeBloka) < 24 && novUrnik[24 - trajanjeBloka][dan] == 0) {
 			return true;
 		}
 		return false;
 	}

}