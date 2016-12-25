
public class Test02 {

    public static void main(String[] args) {
        PostniNaslov a = new PostniNaslov("Sprednja 7", 1000, "Ljubljana");
        PostniNaslov b = new PostniNaslov("Zadnja 7", 1000, "Ljubljana");
        PostniNaslov c = new PostniNaslov("Sprednja 7", 1100, "Ljubljana");
        PostniNaslov d = new PostniNaslov("Sprednja 7", 2000, "Maribor");
        PostniNaslov e = new PostniNaslov("Sprednja 7", 1000, "Ljubljana");

        System.out.println(a.jeEnakKot(a));
        System.out.println(a.jeEnakKot(b));
        System.out.println(a.jeEnakKot(c));
        System.out.println(a.jeEnakKot(d));
        System.out.println(a.jeEnakKot(e));
    }
}
