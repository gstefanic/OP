
import java.util.*;

public class Test08 {

    public static void main(String[] args) {
        Graf graf = new Graf();

        String[] oznake = {"A", "B", "C", "D", "E", "F"};
        int[][] vezi = {
            {0, 1}, {0, 3}, {1, 2}, {2, 3}, {2, 4}, {2, 5},
            {3, 1}, {3, 4}, {3, 5}, {4, 1}, {4, 5}, {5, 0}
        };

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

        for (int i = 0;  i < vozlisca.length;  i++) {
            for (int j = 0;  j < vozlisca.length;  j++) {
                if (i != j) {
                    System.out.printf("Vse poti od %s do %s: %s%n", 
                            vozlisca[i].toString(),
                            vozlisca[j].toString(),
                            urejeniSeznamPoti(graf.vsePoti(vozlisca[i], vozlisca[j])));
                }
            }
        }
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
