public class TestPravokotnik {

	public static void main(String[] args) {
		// izpisem stevilo pravokotnikov na zacetku
		System.out.println("Stevilo pravokotnikov: " + Pravokotnik.vrniStPravokotnikov());

		Pravokotnik p1 = new Pravokotnik(5,3,1,1);
		Pravokotnik p2 = new Pravokotnik();
		
		System.out.println("\n" + Pravokotnik.vrniStPravokotnikov());

	}
}