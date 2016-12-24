import java.util.*;

public class DN01_63160149 {
	public static void main (String[] args) {
		
		Scanner s = new Scanner(System.in);
		byte t = s.nextByte();
		int a;
		int b;
		int c;
		int stKock;
		switch (t) {		
			case 1:	
				a = s.nextInt();			
				stKock = 0;
				stKock = a*a*a;
				System.out.println(stKock);
				break;
			case 3:
				a = s.nextInt();
				stKock = 0;
				for(int i=a; i>0; i--){
					stKock+= (i*i);
				}
				System.out.println(stKock);
				break;
			case 5:
				a = s.nextInt();
				stKock = 0;
				for(int i=a; i>0; i--){
					stKock += (i*i);
				}
				if(a>2){
					for(int i=a-2; i>0; i--){
						stKock-=(i*i);
					}
				}
				System.out.println(stKock);
				break;
			case 4:
				a = s.nextInt();
				b = s.nextInt();
				stKock = 0;
				for(int i=a; i>0; i--){
					stKock+=(i*b);
				}
				System.out.println(stKock);
				break;
			case 6:
				a = s.nextInt();
				b = s.nextInt();
				stKock = 0;
				for(int i=a; i>0; i--){
					stKock+=(i*b);
				}
				if(a>2 && b>2){
					for(int i=a-2; i>0; i--){
						stKock-=(i*(b-2));
					}
				}
				System.out.println(stKock);
				break;
			case 2:
				a = s.nextInt();
				b = s.nextInt();
				c = s.nextInt();				
				stKock = 0;
				stKock=a*b*c;
				System.out.println(stKock);
				break;
		}
	}							
}