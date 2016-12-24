
import java.util.*;

public class Test10 {

    public static void main(String[] args) {
        Graf graf = new Graf();

        String[] oznake = {"A", "B", "C", "D", "E"};
        int[][] vezi = new int[0][2];

        Vozlisce[] vozlisca = new Vozlisce[oznake.length];
        for (int i = 0;  i < oznake.length;  i++) {
            vozlisca[i] = new Vozlisce(oznake[i]);
            graf.dodajVozlisce(vozlisca[i]);
        }
        int stPovezav = vezi.length;
        for (int i = 0;  i < stPovezav;  i++) {
            Graf.dodajPovezavo(vozlisca[vezi[i][0]], vozlisca[vezi[i][1]]);
        }

        System.out.print(graf.toString());
        System.out.println("----------");

        System.out.println(urejeniSeznamPoti(graf.vsePoti(vozlisca[0], vozlisca[2])));
        System.out.println(urejeniSeznamPoti(graf.vsePoti(vozlisca[1], vozlisca[4])));
    }

    private static List<String> urejeniSeznamPoti(List<Pot> poti) {
        List<String> strPoti = new ArrayList<>();
        for (Pot pot: poti) {
            strPoti.add(pot.toString());
        }
        Collections.sort(strPoti);
        return strPoti;
    }
}
