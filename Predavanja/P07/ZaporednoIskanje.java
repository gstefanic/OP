import java.util.*;
public class ZaporednoIskanje {
	public static int poisci1(int[]t, int x) {
		int i = 0;
		// pri konjuinkciji, v primeru, da je prvi pogoj
		// napacen, drugega pogoja sploh ne pregleduje
		// podobno je tudi pri disjunkciji
		// zato pogojev v spodnji fanki ne smemo zamenjati
		while (i<t.length && t[i]!=x) {
			i++;
		}
		if (i<t.length) {
			return i;
		}
		else {
			return -1;
		}

	}

	public static int poisci2(int[] t, int x) {
		for (int i = 0; i < t.length; i++) {
			if (t[i]==x) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] t = {3, 5, 2, 0, -5, 10, 4, 8};
		// v zanki beremo razlicne vrednosti za x
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int x = sc.nextInt();
			System.out.println(x + " " + poisci1(t,x));
			System.out.println(x + " " + poisci2(t,x));

		}
	}
}