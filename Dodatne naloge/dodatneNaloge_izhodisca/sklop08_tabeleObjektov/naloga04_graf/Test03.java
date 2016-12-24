
public class Test03 {

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
    }
}
