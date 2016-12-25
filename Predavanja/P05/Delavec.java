class Delavec {
	private int matSt;
	private String priimek, ime;
	private int stUr;

	// konstruktor
	Delavec() {
		
	}

	Delavec(int matSt) {
		this.matSt = matSt;
	}

	Delavec(int matSt, String priimek, String ime) {
		this.matSt = matSt;
		this.priimek = priimek;
		this.ime = ime;
	}

	Delavec(int matSt, String priimek, String ime, int stUr) {
		this.matSt = matSt;
		this.priimek = priimek;
		this.ime = ime;
		this.stUr = stUr;
	}
	
	// Setter
	public void setMatSt(int matSt) {
		this.matSt = matSt;
	}
	
	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setStUr(int stUr){
		this.stUr = stUr;
	}

	// Getter
	public int getMatSt(){
		return this.matSt;
	}

	public String getPriimek(){
		return this.priimek;
	}
	
	public String getIme(){
		return this.ime;
	}

	public int getStUr(){
		return this.stUr;
	}

	// Utility
	public double zasluzek(double cenaUre){
		return cenaUre * this.stUr;
	}

	public void izpisiVse(){
		System.out.println("Matična številka " + matSt);
		System.out.println("Priimek in ime " + priimek + " " + ime);
		System.out.println("Število ur " + stUr);
	}

	public String toString(){
		return matSt + " " + priimek + " " + ime + " " + stUr;
	}
}