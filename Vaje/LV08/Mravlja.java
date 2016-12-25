
import java.util.Scanner;

public class Mravlja {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int visina = sc.nextInt();
        int sirina = sc.nextInt();

        int x = 0, y = 0;
        long koraki = 0;

        int m = Math.max(visina, sirina);
    	long[][] memo = new long[m+1][m+1];
        System.out.println(stPoti(visina, sirina, memo));
    }
    public static long stPoti(int visina, int sirina, long[][] memo){
    	if(visina == 1 || sirina == 1) {
    		return 1;
    	} else if (memo[visina][sirina]!=0) {
    		return memo[visina][sirina];
    	} else {
    		memo[visina][sirina] = stPoti(visina, sirina - 1, memo) + stPoti(visina - 1, sirina, memo);
    		memo[sirina][visina] = stPoti(visina, sirina - 1, memo) + stPoti(visina - 1, sirina, memo);

    	}
    }

}
