
public class Test04 {

    public static void main(String[] args) {
        Graf graf = new Graf();

        String[] oznake = {"A", "B", "C", "D"};
        int[][] vezi = {
            {0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}, {2, 3}
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
