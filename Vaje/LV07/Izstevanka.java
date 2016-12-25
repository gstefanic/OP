
import java.util.Scanner;

public class Izstevanka {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stOtrok = sc.nextInt();
        int stBesed = sc.nextInt();

        // preberi imena otrok
        String[] otroci = new String[stOtrok];
        for (int i = 0;  i < stOtrok;  i++) {
            otroci[i] = sc.next();
        }

        while(stOtrok != 1) {
            int izbrisi = (stBesed-1)%stOtrok;
            String tmp = otroci[izbrisi];
            System.out.println(tmp);
            otroci = izbrisiVrsticoTabele(otroci, tmp);
            
            stOtrok--; 
            
        }


    }

    public static String[] izbrisiVrsticoTabele(String[] tabela, String ime){
            String[] toReturn = new String[tabela.length -1];
            int stevec = 0;
            int zaporednaSt = 0;

            for (int i = 0; i < tabela.length; i++) {
                if (tabela[i].equals(ime)) {
                    zaporednaSt = i;
                    break;
                }
            }

            for (int i = 0; i < tabela.length; i++) {
                if (i == zaporednaSt) {
                    continue;
                }
                String tmp = tabela[i];
                toReturn[stevec] = tmp;
                stevec++;
            }
            return toReturn;
    }

}
