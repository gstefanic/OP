import java.util.*;
public class DN03_01 {
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
    	this.stVrstic = 0;
    	this.stZnakov = 0;
    	this.zacetekVrstice = true;
		this.zacetekStrani = true;
		prejSkatla = false;
    }

    public void dodajBesedo(int dolzinaBesede) {
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
    	if (zacetekStrani) {
    		stVrstic += velikostSkatle;
    		this.zacetekStrani = false;
    		this.prejSkatla = true;
    		novaVrstica();
    		//dodajOdstavek();
    	} 
    	else if (prejSkatla && (stVrstic+velikostSkatle) <= maxVrstic-1) {
    		this.stVrstic += velikostSkatle;
    		//dodajOdstavek();
    	}
    	else if ((this.stVrstic+velikostSkatle) <= maxVrstic-1) {
    		this.stVrstic += 1+velikostSkatle;
    		dodajOdstavek();
    	} else {
    		novaStran();
    		dodajSkatlo(velikostSkatle);
    	}
    }

    public void dodajOdstavek() {
    	if (zacetekStrani == false) {
    		novaVrstica();
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
    	if ((this.stVrstic < this.maxVrstic-1)) {
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
    	this.stVrstic = 0;
    	this.stStrani++;
    	this.zacetekVrstice = true;
    	this.zacetekStrani = true;
    	prejSkatla = false;
    }

    // izpiši stevilo strani, stevilo vrstic na zadnji strani
    // in stevilo znakov v zadnji vrstici na zadnji strani
    public void izpisi() {
    	System.out.printf("%d%n%d%n%d%n", stStrani, stVrstic+1, stZnakov);
    }
}