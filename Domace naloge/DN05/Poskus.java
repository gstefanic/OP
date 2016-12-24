import java.util.Scanner;
public class Poskus{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in); 
		int dolzinaDolgega = sc.nextInt(); 
		int dolzinaKratkih = sc.nextInt(); 
		int stKratkih = sc.nextInt(); 
		sc.nextLine(); // ! 
		char[] dolgoZaporedje = sc.nextLine().toCharArray();

		for (int i = 0; i < stKratkih; i++) { 
			int steviloEnakihZaporedij=0;
			int sestevekZank=0;
			char[] kratkoZaporedje = sc.nextLine().toCharArray();
			if(dolzinaKratkih>1){
				for(int j=0; j<dolzinaDolgega-dolzinaKratkih+1;j++){
					if (dolgoZaporedje[j]==kratkoZaporedje[0]){
						sestevekZank = 0;
						for(int n=0; n<dolzinaKratkih;n++){
							if(dolgoZaporedje[j+n]==kratkoZaporedje[0+n]){
								sestevekZank++;
							}
							else{
								sestevekZank=0;
							}
						}
						if (sestevekZank==dolzinaKratkih){
							steviloEnakihZaporedij++;
						}
					}
				}
			}
			else if(dolzinaKratkih==1){
				for(int j=0; j<dolzinaDolgega; j++){
					if (dolgoZaporedje[j]==kratkoZaporedje[i]){
						steviloEnakihZaporedij++;
					}
				}
			}
			System.out.println(steviloEnakihZaporedij);
		}
	}
}