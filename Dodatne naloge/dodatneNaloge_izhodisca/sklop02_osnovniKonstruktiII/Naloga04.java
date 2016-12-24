import java.util.*;

class Naloga04 {
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        int hz = sc.nextInt(),
            mz = sc.nextInt(),
            hk = sc.nextInt(),
            mk = sc.nextInt(),
            d = sc.nextInt();
        int zac = hz*60 + mz,
            kon = hk*60 + mk;
        for(int i = zac; i<=kon; i+=d) {
            System.out.printf("%02d:%02d",i/60,i%60);
            System.out.println();
        }
    }
}
