public class TestPravokotnik {
	public static void main(String[] args) {
		Pravokotnik p1 = new Pravokotnik(5,3,1,1);
		Pravokotnik p2 = new Pravokotnik();
		//p1.izpisi();
		//p2.izpisi();

		// prvemu pravokotniku spremenimo velikost in lego
		p1.nastaviVelikost(10, 10);
		p1.nastaviLego(-3,5);
		p1.izpisi();

		// drugi pravokotnik premaknemo
		p2.premakni(-1,4);
		p2.izpisi();

	}
}