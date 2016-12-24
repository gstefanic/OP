import java.util.*;

public class DN03_63160149 {

    public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int maxZnakov = s.nextInt();
		int maxVrstic = s.nextInt();
		int steviloElementov=s.nextInt();
		int stZnakov=0;
		int stVrstic=1;
		int stStrani=1;
		boolean zacetek=true;
		boolean polno=false;
		boolean skatla=false;
		
		for(int i=0; i<steviloElementov; i++){	
			int znak=s.nextInt();
			
			
			if(znak > 0){
				if(stZnakov+znak+1<=maxZnakov){
					stZnakov+=(znak+1);
					polno=false;
				}
				else if(stZnakov+znak==maxZnakov){
					stZnakov+=znak;
					polno=true;
				}
				else if(stZnakov+znak > maxZnakov){
					if(znak==maxZnakov){
						stZnakov=znak;
						polno=true;
						if(stVrstic<maxVrstic)
							stVrstic++;
						else{
							stVrstic=1;
							stStrani++;
						}	
					}
					else{
						polno=false;
						stZnakov=znak+1;
						if(stVrstic<maxVrstic)
							stVrstic++;
						else{
							stVrstic=1;
							stStrani++;
						}	
					}						
				}
				skatla=false;	
				zacetek=false;
			}
			else if(znak==0){
				if(stVrstic<=maxVrstic-2){
					stVrstic+=2;
					stZnakov=0;
				}
				else if(stVrstic==maxVrstic-1 || stVrstic==maxVrstic){
					stVrstic=1;
					stStrani++;
					stZnakov=0;
				}
			}
			else if(znak<0){
				znak=Math.abs(znak);
				if(zacetek==false && skatla==false){
					if(stVrstic+3+znak<=maxVrstic){
						stVrstic+=(3+znak);
						stZnakov=0;
						skatla=true;
					}
					else if(stVrstic+2+znak==maxVrstic || stVrstic+1+znak==maxVrstic){
						stZnakov=0;
						stVrstic=1;
						stStrani++;
						skatla=false;
						zacetek=true;
					}
					else if(stVrstic+znak+1>maxVrstic){
						if(znak==maxVrstic || znak==maxVrstic-1){
							stZnakov=0;
							stStrani+=2;
							stVrstic=1;
							skatla=false;
							zacetek=true;
						}
						else{
							stVrstic=znak+2;
							stZnakov=0;
							stStrani++;
							skatla=true;
							zacetek=false;
						}
					}
				}
				else if(zacetek==true){
					if(znak==maxVrstic || znak==maxVrstic-1){
							stZnakov=0;
							stStrani++;
							stVrstic=1;
							skatla=false;
							zacetek=true;
					}
					else{
						stVrstic=znak+2;
						stZnakov=0;
						skatla=true;
						zacetek=false;
					}
				}
				else if(skatla==true){
					if(stVrstic+znak+1<=maxVrstic){
						stZnakov=0;
						stVrstic+=(znak+1);
						skatla=true;
						zacetek=false;
					}
					else if(stVrstic+znak==maxVrstic || stVrstic+znak-1==maxVrstic){
						stZnakov=0;
						stVrstic=1;
						stStrani++;
						skatla=false;
						zacetek=true;
					}
					else{
						if(znak==maxVrstic || znak==maxVrstic-1){
							stZnakov=0;
							stStrani+=2;
							stVrstic=1;
							skatla=false;
							zacetek=true;
						}
						else{
							stVrstic=znak+2;
							stZnakov=0;
							stStrani++;
							skatla=true;
							zacetek=false;
						}
					}
				}
			}				
		}

		System.out.println(stStrani);
		System.out.println(stVrstic);
		if(polno==true)
			System.out.println(stZnakov);
		else{
			System.out.println(stZnakov-1);
		}
		
	}
}	