import java.util.*;
public class DemoSkladT {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Doloci kapaciteto sklada");
		int kapaciteta = sc.nextInt();
		SkladT sklad = new SkladT(kapaciteta);

		while (true) {
			System.out.println("Izberi operacijo (1 - dodaj, 2 - odvzemi, 3 - vrhnji, 4 - jePrazen, 5 - velikost, 6 - izpisi, 7 - exit)");
			int odg = sc.nextInt();
			switch (odg) {
				case 1:
					System.out.println("Vpisi podatek");
					int podatek = sc.nextInt();
					// ovijalni razred Integer
					Integer obj = new Integer(podatek);
					sklad.dodaj(obj);
					break;
				case 2:
					System.out.println("Odvzel sem " + sklad.odvzemi());
					break;
				case 3:
					System.out.println("Na vrhu je " + sklad.vrhnji());
					break;
				case 4:
					System.out.println(sklad.jePrazen());
					break;
				case 5:
					System.out.println("Velikost je " + sklad.velikost());
					break;
				case 6:
					sklad.izpisiVsebino();
					break;
				case 7:
					System.exit(0);
					break;
			}
		}
	}
}