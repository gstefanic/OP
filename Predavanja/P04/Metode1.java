import java.util.*;
class Metode1 {
	public static void naslov1() {
		System.out.println("FRI");
		System.out.println("Večna pot 113");
		System.out.println("1000 Ljubljana");
	}
	
	public static void naslov2(String ime, String ulicaSt, String posta) {
		System.out.println(ime);
		System.out.println(ulicaSt);
		System.out.println(posta);	
	}

	public static String naslov(String ime, String naslov) {
		return ime+"\n"+naslov+"\n";
	}

	// metoda izračuna vrednost depozita po enem letu
	public static void naslov3(double g, double o) {
		System.out.println(g+g*o/100);
	}

	public static double naslov4(double g, double o){
		return (g+g*o/100);
	}

	// program, ki poišče vsa popolna števila na intervalu
	// naravno število n je popolno, če je enako vsoto svojih pravih deliteljev
	// npr.: 6; 1*2*3=6; 1+2+3=6
	// metoda za število n ugotovi ali je popolno ali ne
	public static boolean jePopolno(int n) {
		// vsota
		int v = 0;
		for (int i = 1; i <= n/2; i++) {
			if (n%i==0) {
				// dosedanji vrednosti vsote prištejem delitelj, ki ga najdem
				v += i;
			}
		}
		return v==n;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//naslov1();
		//naslov2("FMF", "Jadranska ulica 26", "1000 Ljubljana");
		/*
		for (int i = 0; i < 3; i++) {
			System.out.println(naslov4(sc.nextDouble(), sc.nextDouble()));
		}
		*/
		System.out.println(jePopolno(sc.nextInt()));
	}
}
