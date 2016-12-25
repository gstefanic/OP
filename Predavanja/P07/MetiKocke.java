import java.util.*;
public class MetiKocke {
	public static void main(String[] args) {
		int[] stevci = {0, 0, 0, 0, 0, 0};

		// zanka za simulacijo meta kocke
		for (int i = 0; i < 3000; i++) {
			// spremenljivka met zavzame vrednosti od 0 do 5
			// in tako sluzi kot indeks
			int met = (int)(Math.random()*6);
			stevci[met]++;
		}


		// izpis s sprehodom skozi zanko
		for (int i = 0; i < stevci.length; i++) {
			System.out.print(stevci[i] + " ");
		}

		/*
		for(int i : stevci) {
			System.out.print(stevci[i] + " ");
		}
		*/

		// iskanje podatka v tabeli
		

	}

	public static int poisci(int[] t, int x) {
		return 0;
	}

}