import java.util.*;

abstract class Atlet {
	private int startnaSt;
	private String priimek;
	private String ime;
	private String klub;

	public Atlet(int startnaSt, String priimek, String ime, String klub) {
		this.startnaSt = startnaSt;
		this.priimek = priimek;
		this.ime = ime;
		this.klub = klub;
	}

	public abstract void beriRezultat(Scanner sc);
	public abstract boolean jeBoljsi(Atlet a);

	@Override
	public String toString() {
		return startnaSt + " " + this.priimek + " " + this.ime + " " + this.klub;
	}
}

class Metalec extends Atlet {
	private double[] dolzineMetov;

	public Metalec(int startnaSt, String priimek, String ime, String klub) {
		super(startnaSt, priimek, ime, klub);
		this.dolzineMetov = dolzineMetov;
	}

	@Override
	public void beriRezultat(Scanner sc) {
		for (int i = 0; i < this.dolzineMetov.length; i++) {
			dolzineMetov[i] = sc.nextDouble();
		}
	}

	@Override
	public boolean jeBoljsi(Atlet a) {
		if (a == this || a == null || !(a instanceof Metalec)) {
			return false;
		}

		Metalec m = (Metalec) a;
		return this.najdaljsiMet() > m.najdaljsiMet();
	}

	public double najdaljsiMet() {
		double max = this.dolzineMetov[0];
		for (int i = 1; i < this.dolzineMetov.length; i++) {
			if (this.dolzineMetov[i] > max) {
				max = this.dolzineMetov[i];
			}
		}
		return max;
	}

	@Override
	public String toString() {
		String s = super.toString();
		for (int i = 0; i < this.dolzineMetov.length; i++) {
			s += dolzineMetov[i] + " ";
		}
		return s;
	}

}

class Tekac extends Atlet {
	private byte ure, minute, sekunde, stotinke; // byte... just because we can
    
    public Tekac(int startnaSt, String priimek, String ime, String klub) {
    	super(startnaSt, priimek, ime, klub);
    }

    @Override
    public void beriRezultat(Scanner sc) {
    	this.ure = (byte) sc.nextInt();
    	this.minute = (byte) sc.nextInt();
    	this.sekunde = (byte) sc.nextInt();
    	this.stotinke = (byte) sc.nextInt();
    }

    @Override
    public boolean jeBoljsi(Atlet a) {
    	if (this == a || a == null || !(a instanceof Tekac)) {
    		return false;
    	}

    	Tekac t = (Tekac) a;
    	return this.casSek() < t.casSek();
    }

    public double casSek() {
    	return this.ure*3600 + this.minute*60 + this.sekunde + 0.01*this.stotinke;
    }

    @Override
    public String toString() {
    	String s = super.toString();
    	s += this.ure + " " + this.minute + " " + this.sekunde + " " + this.stotinke;
    	return s;
    }

}

public class AtletskoTekmovanje {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int stAtletov = sc.nextInt();
		Atlet[] atleti = new Atlet[stAtletov];

		for (int i = 0; i < stAtletov; i++) {
			int startnaSt = sc.nextInt();
			String priimek = sc.next();
			String ime = sc.next();
			String klub = sc.next();

			if (sc.nextInt() == 1) {
				atleti[i] = new Metalec(startnaSt, priimek, ime, klub);
			}
			else {
				atleti[i] = new Tekac(startnaSt, priimek, ime, klub);
			}

			atleti[i].beriRezultat(sc);
			System.out.println(atleti[i].toString());
		}

		// koda, ki sledi isce najboljsega metalca in najboljsega tekaca
		Metalec najMetalec = null;
		Tekac najTekac = null;

		for (int i = 0; i < stAtletov; i++) {
			if (atleti[i] instanceof Tekac) {
				if (najTekac == null || atleti[i].jeBoljsi(najTekac)) {
					najTekac = (Tekac) atleti[i];					
				}
			}
			else {
				if (najMetalec == null || atleti[i].jeBoljsi(najTekac)) {
					najMetalec = (Metalec) atleti[i];
				}
			}
		}

		// izpis rezultatov
		System.out.println();
		System.out.println("Najboljsi tekac");
		System.out.println(najTekac.toString());
		System.out.println();
		System.out.println("Najboljsi metalec");
		System.out.println(najMetalec.toString());

	}
}