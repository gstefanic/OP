abstract class Zival {
	private String imeZivali;

	public Zival(String imeZivali) {
		this.imeZivali = imeZivali;
	}

	public String vrniIme() {
		return this.imeZivali;
	}

	public abstract void oglasanje();
}

class Pes extends Zival {

	public Pes(String imePsa) {
		super(imePsa);
	}

	public void oglasanje() {
		System.out.println("hov-hov");
	}
}

class Macka extends Zival {

	public Macka(String imeMacke) {
		super(imeMacke);
	}

	public void oglasanje() {
		System.out.println("mjav-mjav");
	}
}

class Krava extends Zival {

	public Krava(String imeKrave) {
		super(imeKrave);
	}

	public void oglasanje() {
		System.out.println("muu");
	}
}

public class DemoAbstraktni {
	public static void main(String[] args) {
		Zival z;
		Pes p = new Pes("Beno");
		Macka m = new Macka("Miki");
		Krava k = new Krava("Liska");
		p.oglasanje();
		m.oglasanje(); 
		k.oglasanje();
		z = p;
		z.oglasanje();
	}
}