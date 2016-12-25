
public class Test10 {

    public static void main(String[] args) {
        int stClanov = 3;
        int stNaslovov = 1;
        Knjiznica knjiznica = new Knjiznica(stClanov, stNaslovov);

        for (int i = 0;  i < 5;  i++) {
            knjiznica.posodi(0, 0);
            knjiznica.posodi(1, 0);
            knjiznica.posodi(2, 0);
            knjiznica.posodi(2, 0);
            System.out.println(knjiznica.najClan(0));
        }
    }
}
