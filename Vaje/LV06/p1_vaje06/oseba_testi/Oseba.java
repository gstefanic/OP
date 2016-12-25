public class Oseba {

	static int steviloUstvarjenih = 0;
	String ime, priimek;
	char spol;
	int letoRojstva;
	Oseba oce, mati;

	public Oseba(String ime, String priimek, char spol, int letoRojstva) {
		this.ime = ime;
		this.priimek = priimek;
		this.spol = spol;
		this.letoRojstva = letoRojstva;
		// klic drugega konstruktorja v istem razredu
		//this(ime, priimek, spol, letoRojstva, null, null);

		steviloUstvarjenih++;
	}

	Oseba(String ime, String priimek, char spol, int letoRojstva,
Oseba oce, Oseba mati) {
		this.ime = ime;
		this.priimek = priimek;
		this.spol = spol;
		this.letoRojstva = letoRojstva;
		this.oce = oce;
		this.mati = mati;
		steviloUstvarjenih++;
	}

	public String vrniIme(){
	    return this.ime;
	}

	public void nastaviIme(String ime){
	    this.ime = ime;
	}

	public String toString(){
		//return String.format();
	    return ""+ime+" "+priimek+" ("+spol+"), "+letoRojstva;
	}

	public int starost(int leto){
	    return (leto - letoRojstva);
	}

	public boolean jeStarejsaOd(Oseba os){
	    if (this.letoRojstva < os.letoRojstva) {
	    	return true;
	    }

	    return false;

	    // return (this.letoRojstva < os.letoRojstva);
	}

	public String imeOceta(){
		if (this.oce!=null) {
		    return this.oce.vrniIme();	
		}
		return null;
	}

	public boolean jeBratAliSestraOd(Oseba os){
	    if (this.oce != null && this.mati!= null && this.oce==os.oce && this.mati==os.mati && this!=os) {
	    	return true;
	    }
		return false;	    
	}

	public boolean jeSestraOd(Oseba os){
	    if (this.jeBratAliSestraOd(os) && this.spol=='Z') {
	    	return true;
	    }
	    return false;
	}

	public boolean jeTetaOd(Oseba os){
		if (this.oce != null && this.jeSestraOd(os.oce) ||
			this.mati != null && this.jeSestraOd(os.mati)) {
			return true;
		}
	    return false;
	}

	public boolean jeOcetovskiPrednikOd(Oseba os){
		Oseba tmp = os.oce;

		while (tmp!=null) {
			if (this==tmp) {
				return true;
			}
			tmp = tmp.oce;
		}

	    return false;
	}

	public static int steviloUstvarjenih(){
	    return steviloUstvarjenih;
	}

}