public class TestDelavec {
	public static void main(String[] args) {
		// Kreiranje objekta
		Delavec d = new Delavec();

		// izpis trenutne vsebine
		//d.izpisiVse();

		// vpis vrednosti atributov
		d.setMatSt(1);
		d.setPriimek("Štefanič");
		d.setIme("Gregor");
		d.setStUr(3*8+5);

		System.out.println(d.zasluzek(3.8));

		System.out.println(d.toString());

		// kreiramo tri nove objetke, vsakega s 
		// svojim konstruktorjem
		Delavec d1 = new Delavec(1000, "Novak", "Janez");
		Delavec d2 = new Delavec(1001, "Petelin", "Drago", 182);
		Delavec d3 = new Delavec(1002);

		// izpisemo vsebino vseh objektov
		System.out.println(d1.toString() + "\n" +
			d2.toString() + "\n" + 
			d3.toString());
	}
}