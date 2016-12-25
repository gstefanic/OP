import java.util.*;
public class KozarciMarmelade {
    // deklaracije konstant
    static final int PREDPISANO = 700;
    static final int ST_IZMEN = 3;
    static final int ST_KOZARCEV = 10;

    // deklaracija tabel
    static int[][] mk = new int[ST_IZMEN][ST_KOZARCEV];
    static int[] maxOdst = new int[ST_IZMEN];
    static int[] maxIndeks = new int[ST_IZMEN];

    // pristop top-down: za vsak podproblem si zamislimo ustrezno metodo
    public static void main(String[] args) {
    	pripravaPodatkov();
    	poisciNajvecjaOdstopanja();
    	izpisiRezultate();
    }

	// napolnimo tabelo mk z nakljucnimi stevili od 670 do 730
    private static void pripravaPodatkov() {
    	for (int i = 0; i < mk.length; i++) {
    		for (int j = 0; j < mk[i].length; j++) {
    			mk[i][j] = PREDPISANO-30+(int)(Math.random()*61);
    			System.out.printf("%5d", mk[i][j]);
    		}
    		System.out.println();
    	}
    }

    // poiscemo najvecja odsopanja za posamezno izmeno
    private static void poisciNajvecjaOdstopanja() {
    	for (int i = 0; i < mk.length; i++) {
    		// zacetna vrednost maksimuma je kar prvi element
    		maxOdst[i] = Math.abs(mk[i][0]-PREDPISANO);
    		for (int j = 1; j < mk[i].length; j++) {
    			int odstopanjeTrenutnega = Math.abs(mk[i][j]-PREDPISANO);
    			if (odstopanjeTrenutnega>maxOdst[i]) {
    				maxOdst[i] = odstopanjeTrenutnega;
    				maxIndeks[i] = j;
    			}
    		}
    	}
    }

    // izpisemo rezultate
    private static void izpisiRezultate() {
    	System.out.println("Izmena\tKozarec\tOdstopanje");
    	for (int i = 0; i < ST_IZMEN; i++) {
    		System.out.printf("%d\t%d\t%d%n", (i+1), maxIndeks[i], maxOdst[i]);
    	}
    }

}