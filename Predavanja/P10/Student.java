public class Student {
    private int vpisnaSt;
    private String priimek, ime;

    public Student(int vpisnaSt, String priimek, String ime) {
    	this.vpisnaSt = vpisnaSt;
    	this.priimek = priimek;
    	this.ime = ime;
    }

    public void vpisiVpisnaSt(int vpisnaSt) {
    	this.vpisnaSt = vpisnaSt;
    }

    public void vpisiPriimek(String priimek) {
    	this.priimek = priimek;
    }

    public void vpisiIme(String ime) {
    	this.ime = ime;
    }

    public int vrniVpisnoSt() {
    	return this.vpisnaSt;
    }

    public String vrniPriimek() {
    	return this.priimek;
    }

    public String vrniIme() {
    	return this.ime;	
    }

    public void izpisiVse() {
    	System.out.println(this.vpisnaSt + " " + this.priimek + " " + this.ime);
    }

}

class IzredniStudent extends Student {
	private int solnina;

	public IzredniStudent(int vpisnaSt, String priimek, String ime, int solnina) {
		super(vpisnaSt, priimek, ime);
		this.solnina = solnina;
	}

	public void vpisiSolnino(int solnina) {
		this.solnina = solnina;
	}

	public int vrniSolnino() {
		return this.solnina;
	}

	@Override
	public void izpisiVse() {
		System.out.println(this.vrniVpisnoSt() + " " + this.vrniPriimek() + " " + this.vrniIme() + " " + this.solnina);
	}
}

class DemoDedovanje {
    public static void main(String[] args) {
    	Student s = new Student(63160303, "Štefanič", "Gregor");
    	s.izpisiVse();

    	IzredniStudent is = new IzredniStudent(63160303, "Štefanič", "Gregor", 1200);
    	is.izpisiVse();
    }
}