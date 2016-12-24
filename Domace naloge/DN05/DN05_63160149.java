import java.util.*;

public class DN05_63160149{
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		long time1 = System.currentTimeMillis();
		int dolzinaDolgega=s.nextInt();
		int dolzinaKratkega=s.nextInt();
		int stKratkih=s.nextInt();
		s.nextLine();
		String dolgoZaporedje= s.nextLine();
		String zacasno = "";
		int indeks;
		int zamik = dolzinaDolgega-dolzinaKratkega;
		int [] stPonovitev = new int[(int)Math.pow(2, dolzinaKratkega)];
		
		for(int i=0; i<=zamik; i++){
			zacasno=dolgoZaporedje.substring(i, i+dolzinaKratkega);
			indeks = Integer.parseInt(zacasno, 2);
			stPonovitev[indeks]++;
		}
		zacasno="";
		for(int k=0; k<stKratkih; k++){
			String kratko = s.nextLine();
			//System.out.println(stPonovitev[Integer.parseInt(kratko, 2)]);
			zacasno+=(stPonovitev[Integer.parseInt(kratko, 2)])+"\n";
		}
		System.out.print(zacasno);
		long time2=System.currentTimeMillis();
		//System.out.println(time2-time1);

	}
}



//naredi tabelo ki prešteje kolikokrat se vsako število ponovi v dolgem zaporedju in se to shrani v indeks enak temu številu. 
//nato samo pretvori binarno število v desetiško in izpiše število v indeksu z tem številom!