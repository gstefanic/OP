
public class Test02 {

    public static void main(String[] args) {
        int n = 7;
        Filozof[] ff = new Filozof[n];
        for (int i = 0;  i < n;  i++) {
            ff[i] = new Filozof();
        }
        for (int i = 0;  i < n;  i++) {
            ff[i].nastaviSoseda(ff[(n + i - 1) % n], ff[(i + 1) % n]);
        }

        ff[0].primiLevo();
        System.out.println(ff[0].kolikoPalicicDrzi());

        ff[6].primiDesno();
        System.out.println(ff[6].kolikoPalicicDrzi());

        ff[0].izpustiLevo();
        System.out.println(ff[0].kolikoPalicicDrzi());

        ff[6].primiDesno();
        System.out.println(ff[6].kolikoPalicicDrzi());
    }
}
