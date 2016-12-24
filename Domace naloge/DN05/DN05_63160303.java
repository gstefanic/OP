import java.util.*;
public class DN05_63160303 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		Scanner sc = new Scanner(System.in);
		int dolzinaDolgega = sc.nextInt();
		int dolzinaKratkih = sc.nextInt();
		int stKratkih = sc.nextInt();
		sc.nextLine(); // !
		String dolgoZaporedje = sc.nextLine();

		// stetje vseh moznih zaporedij 2^20
		int[] counters = new int[1048576];

		for (int i = dolzinaKratkih; i < dolzinaDolgega+1; i++) {
			int zacetek = i - dolzinaKratkih;
			int konec = i;
			counters[toBinary(dolgoZaporedje.substring(zacetek,konec))]++;
		}

		// izpisi stevce za zaporedja
		String out = "";
		for (int i = 0; i < stKratkih; i++) {
			String st = sc.nextLine();

			//System.out.println(counters[toBinary(st)]);
			out += counters[toBinary(st)] + "\n";
		}
		System.out.print(out);

		//char[] test = "00".toCharArray();
		//System.out.println(toBinary(test));

		long stopTime = System.currentTimeMillis();
      	long elapsedTime = stopTime - startTime;
      	System.out.println(elapsedTime);
	}

	public static int toBinary(String str) {
		return Integer.parseInt(str, 2);
	}

	public static char[] pomakniLevo(char[] charArray) {
		for (int i = 0; i < charArray.length-1; i++) {
			charArray[i] = charArray[i+1];
		}
		return charArray;
	}
}