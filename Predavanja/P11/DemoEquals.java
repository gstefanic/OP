public class DemoEquals {
	public static void main(String[] args) {
		
	}
}

abstract class Zival {
	private String imeZivali;

	public Zival(String imeZivali) {
		this.imeZivali = imeZivali;
	}

	public String vrniIme() {
		return this.imeZivali;
	}

	public abstract void oglasanje();

	public boolean equals(Zival z) {
		return this.imeZivali.equals(z.vrniIme());
	}
}