import java.util.*;
public class DN03_63160303 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		// preberi podatke o knjigi
		int maxZnakov = sc.nextInt(),
			maxVrstic = sc.nextInt(),
			stElementov = sc.nextInt();

		Knjiga knjiga = new Knjiga(maxZnakov, maxVrstic);

		// preberi <stElementov> stevil
		// z zanko for
		for (int i = 0; i < stElementov; i++) {
			int element = sc.nextInt();
			if (element > 0) {
				// nova beseda dolzine <element> znakov
				knjiga.dodajBesedo(element);
			}
			else if (element < 0) {
				// nova skatla dolzine abs(<element>) vrstic
				knjiga.dodajSkatlo(-element);
			}
			else if (element == 0){
				// nov odstavek
				knjiga.dodajOdstavek();
			}
		}

		knjiga.izpisi();

	}
}

class Knjiga {
    private int stZnakov,
    			stVrstic,
    			stStrani;
    private int maxZnakov,
    			maxVrstic;
	private boolean zacetekVrstice,
					zacetekStrani,
					prejSkatla;

    Knjiga(int maxZnakov, int maxVrstic) {
    	this.maxZnakov = maxZnakov;
    	this.maxVrstic = maxVrstic;
    	this.stStrani = 1;
    	this.stVrstic = 1;
    	this.stZnakov = 0;
    	this.zacetekVrstice = true;
		this.zacetekStrani = true;
		prejSkatla = false;
    }

    public void dodajBesedo(int dolzinaBesede) {
        prejSkatla = false;
        /*if (prejSkatla) {
            novaVrstica();
        }*/
    	// preveri, ali je trenutna vrstica prazna
    	if (zacetekVrstice) {
    		// ce je prazna, stZnakov pristej <dolzinaBesede>
    		// in nastavi zacetekVrstice na false
    		this.stZnakov += dolzinaBesede;
    		this.zacetekVrstice = false;
    		this.zacetekStrani = false;
    		this.prejSkatla = false;
    	}
    	// ce trenutna vrstica ni prazna, preveri, ali 
    	// lahko v trenutno vrstico zapisemo presledek in novo besedo
		else if ((this.stZnakov+1+dolzinaBesede) <= this.maxZnakov) {
    		this.stZnakov += 1+dolzinaBesede;
    	}
    	// ce tega ne moremo storiti, pojdi v novo vrstico
    	// in se enkrat poklici metodo dodajBesedo
    	else {
    		novaVrstica();
    		dodajBesedo(dolzinaBesede);
    	}
    }

    public void dodajSkatlo(int velikostSkatle) {
        // preverimo ali smo na zacetku strani
    	if (zacetekStrani) {
            // ce smo na zacetku strani, pristejemo <velikostSkatle>-1
            // vrstic, nastavimo zacetekStrani na false in prejSkatla na true
            // ter naredimo nov odstavek oz. vstavimo prazno stran
    		stVrstic += velikostSkatle-1;
    		this.zacetekStrani = false;
    		this.prejSkatla = true;
    		dodajOdstavek();
    	} 
        // preverimo, ali je bil prejsnji element skatla, in ce lahko
        // novo skatlo velikosti <velikostSkatle> vstavimo na trenutno stran
    	else if (prejSkatla && (stVrstic+velikostSkatle-1) <= maxVrstic) {
    		this.stVrstic += velikostSkatle-1;
            prejSkatla = true;
    		dodajOdstavek();
    	}
        // ce nismo na zacetku strani in zelimo vstaviti skatlo...
        // preverimo, ali lahko skatlo (in se eno prazno vrstico)
        // vstavimo na trenutno stran - potrebujemo 2 vrstici vec kot
        // v zgornjem primeru, saj moramo kazalec postaviti v novo vrstico 
        // nato pa se eno vrstico naprej (s tem ustvarimo prazno vrstico pred
        // skatlo), nato pa se skatlo
    	else if ((this.stVrstic+velikostSkatle+1) <= maxVrstic) {
            this.stVrstic += velikostSkatle+1;
            // vstavimo prazno vrstico, ce je to mogoce ter 
            // nastavimo prejSkatla na true, saj nam v primeru, da
            // sledi se ena skatla, ni potrebno vstaviti se ene prazne 
            // vrstice
    		dodajOdstavek();
            prejSkatla = true;
    	} 
        // v primeru, da na trenutni strani ni dovolj prostora za novo
        // skatlo velikosti <velikostSkatle>, vstavimo novo stran
        else {
    		novaStran();
    		dodajSkatlo(velikostSkatle);
    	}
    }

    // dodajOdstavek()... dodaj prazno vrstico, ce nismo
    // na zacetku strani, in "kazalec" postavimo na vrstico,
    // v katero lahko zapisujemo
    // ce nismo na zacetku strani gremo v novo vrstico
    public void dodajOdstavek() {
    	if (zacetekStrani == false) {
    		novaVrstica();
            // skocili smo v novo vrstico, vendar smo lahko hkrati
            // skocili tudi na novo stran, zato moramo se enkrat preveriti
            // ali smo na zacetku strani. Ce nismo, skocimo v novo vrstico
    		if (zacetekStrani == false) {
                novaVrstica();	
    		}
    	}
    }

    //
    private void novaVrstica() {
    	// preveri, ali lahko na trenutno stran dodano se eno vrstico
    	// ce je to mogoce, povecaj stevilo vrstic za 1, nastavi 
    	// trenutno stevilo znakov v vrstici na 0 ter nastavi boolean
    	// zacetekVrstice na true
    	if ((this.stVrstic < this.maxVrstic)) {
    		this.stVrstic++;
    		this.stZnakov = 0;
    		this.zacetekVrstice = true;
    	}
    	// ce na trenutno stran ne moremo vec dodati nove vrstice,
    	// pojdi na novo stran
    	else {
    		novaStran();
    	}
    }

    // nastavi stZnakov na 0, stVrstic na 1, povecaj
    // stStrani za 1 ter nastavi zacetekVrstice in zacetekStrani na true
    private void novaStran() {
    	this.stZnakov = 0;
    	this.stVrstic = 1;
    	this.stStrani++;
    	this.zacetekVrstice = true;
    	this.zacetekStrani = true;
    	prejSkatla = false;
    }

    // izpiši stevilo strani, stevilo vrstic na zadnji strani
    // in stevilo znakov v zadnji vrstici na zadnji strani
    public void izpisi() {
    	System.out.printf("%d%n%d%n%d%n", stStrani, stVrstic, stZnakov);
    }
}