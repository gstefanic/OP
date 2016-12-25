import java.util.*;
public class Primer5 {

    public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int vsota = 0;
		// dokler obstaja nasledjni podatek
		while(sc.hasNext()) {
			int a = sc.nextInt();
			vsota += a;
		}
		
    }
}