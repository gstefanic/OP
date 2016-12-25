
import java.util.Scanner;
import java.util.Arrays;

public class Zgoscenke2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stZgoscenk = sc.nextInt();
        int kapacitetaZgoscenke = sc.nextInt();

        int[] zgoscenke = new int[stZgoscenk];
 
        while (sc.hasNextInt()) {
        	int velikostDatoteke=sc.nextInt();
        	int zgoscenkaZaPisanje = najboljPraznaZgoscenka(zgoscenke, kapacitetaZgoscenke, velikostDatoteke);
        	if (zgoscenkaZaPisanje==-1) {
        		break;
        	}
        	else {
        		zgoscenke[zgoscenkaZaPisanje] += velikostDatoteke;
        		System.out.printf("%d EP -> zgoscenka %d %s%n", velikostDatoteke, zgoscenkaZaPisanje+1, tabelaToString(zgoscenke));
        	}
        }

    }

    // ce ni prostora na nobeni zgoscenki vrne -1
    public static int najboljPraznaZgoscenka(int[] zgoscenke, int kapacitetaZgoscenke, int velikostDatoteke){
    	int najboljPraznaZgoscenka = -1;
        for (int i = 0; i < zgoscenke.length; i++) {
        	if ((zgoscenke[i]+velikostDatoteke)<=kapacitetaZgoscenke) {
        		najboljPraznaZgoscenka = 0;
        	}
        }

        if (najboljPraznaZgoscenka==0) {
	        for (int i = 0; i < zgoscenke.length; i++) {
	        	if (zgoscenke[i] < zgoscenke[najboljPraznaZgoscenka]) {
	        		najboljPraznaZgoscenka = i;
	        	}
	        }
        }


        return najboljPraznaZgoscenka;
    }

    // tabela to string
    public static String tabelaToString(int[] tabela){
        String toReturn = "[";
        for (int i = 0; i<tabela.length; i++) {
        	toReturn += ""+tabela[i];
        	if (i<tabela.length-1) {
        		toReturn += ", ";
        	}
        }

        return toReturn+"]";
    }
}
