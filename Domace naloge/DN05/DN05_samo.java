import java.util.*;	
class DN05_samo{
	public static void main(String[] args){
		long firstTime=System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int dolzinaDolgega = sc.nextInt();
		int	dolzinaKratkih = sc.nextInt();
		int stKratkih = sc.nextInt();
		sc.nextLine(); 
		char [] dolgoZaporedje = sc.nextLine().toCharArray();
		int [] tabelaStevil=new int[16777040];
		String stevilka = "";
		String drugaStevilka="";
		String izhod= "";
		for(int i=0;i<(dolzinaDolgega-dolzinaKratkih+1);i++){
			for(int j=0;j<dolzinaKratkih;j++){
				stevilka+=dolgoZaporedje[i+j];
			}
			
			int Desetica = Integer.parseInt(stevilka, 2);
			tabelaStevil[Desetica]+=1;
			stevilka="";
		}
		
		for( int i = 0;  i < stKratkih;  i++) {
			String kratkoZaporedje = sc.nextLine();
			int drugaDesetica=Integer.parseInt(kratkoZaporedje,2);
			izhod+=tabelaStevil[drugaDesetica]+"\n";
		}
		
		System.out.print(izhod);
		
		long secondTime=System.currentTimeMillis();
		long elapsed=secondTime-firstTime;
		System.out.println(elapsed+"Cas");
	}
}