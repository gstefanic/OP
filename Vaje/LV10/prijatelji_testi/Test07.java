
public class Test07 {

    public static void main(String[] args) {
        PostniNaslov naslov = new PostniNaslov("Sprednja 7", 1000, "Ljubljana");

        Oseba a = new Oseba("A A", 30, naslov);
        Oseba b = new Oseba("B B", 25, naslov);
        Oseba c = new Oseba("C C", 27, naslov);
        Oseba d = new Oseba("D D", 26, naslov);
        Oseba e = new Oseba("E E", 27, naslov);

        a.nastaviPrijatelje(new Oseba[]{b, c, d, e});
        b.nastaviPrijatelje(new Oseba[]{a, c, d, e});
        d.nastaviPrijatelje(new Oseba[]{a, b, c, e});
        e.nastaviPrijatelje(new Oseba[]{a, b, c, d});

        izpisiOsebo(a.najstarejsiPrijatelj());
        izpisiOsebo(b.najstarejsiPrijatelj());
        izpisiOsebo(c.najstarejsiPrijatelj());
        izpisiOsebo(d.najstarejsiPrijatelj());
        izpisiOsebo(e.najstarejsiPrijatelj());
    }

    private static void izpisiOsebo(Oseba oseba) {
        if (oseba == null) {
            System.out.println("null");
        } else {
            System.out.println(oseba.toString());
        }
    }
}
