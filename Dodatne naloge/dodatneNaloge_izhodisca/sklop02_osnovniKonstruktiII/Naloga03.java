import java.util.*;

public class Naloga03 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int best = 0, bestNr = 0;
		boolean prviDoKonca = false;
		for (int i = 0; i < n; i++) {
			int v1 = sc.nextInt();
			if (v1!=0) {
				int v2 = sc.nextInt();
				if (v2!=0 && prviDoKonca==false) {
				       	prviDoKonca = true;
					bestNr = i+1;
                                        best = v1+v2;
				}
				else if (v2!=0 && (v1+v2)<best) {
					bestNr = i+1;
					best = v1+v2;
				}
			}
			else continue;
		}
		if (best == 0) {
			System.out.println("NIHCE");
		}
		else {
			System.out.println(""+ bestNr +"\n" + best);
		}
	} 
}
