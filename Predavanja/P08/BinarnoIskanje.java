import java.util.*;
public class BinarnoIskanje {

	// ze urejena tabela
	public static int poisciBinarno(int[] t ,int x) {
		// leva in desna meja
		int l = 0, d = t.length-1;

		while (l<=d) {
			// indeks elementa, ki je na sredini intervala
			int s = (l+d)/2;
			if (t[s]==x) {
				return s;
			}
			else if (t[s]>x) {
				// z iskanjem nadaljujemo v levi polovici
				d = s-1;
			}
			else {
				// z iskanjem nadaljujemo v desni polovici
				l = s+1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] t = {-3, 0, 1, 3, 5, 7, 10, 12, 15};
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int x = sc.nextInt();
			System.out.println(poisciBinarno(t, x));
		}
	}

}