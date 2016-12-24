import java.util.*;
class Naloga05{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min = 0,
		    max = 0;
		double avg = 0;
		double std = 0;
		int i = 0, n = 0;
		while (true){

			if (sc.hasNextInt()){

			
			n = sc.nextInt();
			if (min==max && min == 0) {min = n; max = n;}
			if (n<min) min = n;
			if (n>max) max = n;
			std = (((std*std)+(avg*avg))*i+(n*n));
			avg = ((avg*i)+n)/(i+1);
			std = Math.sqrt(std/(i+1)-(avg*avg));
			
			//System.out.println(max + " " + min + " " + avg + " " + std);
			System.out.printf("%d %d %.2f %.2f\n", max, min, avg, std);
			} else break;
			i++;
		}
	}

}
