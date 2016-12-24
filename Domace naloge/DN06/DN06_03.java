import java.util.*;
public class DN06_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stVrstic = sc.nextInt();
		int stStolpcev = sc.nextInt();

		int[][] plevel = new int[stVrstic + 2][stStolpcev + 2];
		for (int i = 1; i < stVrstic + 1; i++) {
			for (int j = 1; j < stStolpcev + 1; j++) {
				plevel[i][j] = sc.nextInt();
			}
		}

		int stOgraj = 0;
		for (int i = 1; i < stVrstic + 1; i++) {
			for (int j = 1; j < stStolpcev + 1; j++) {
				int t = plevel[i][j], l = plevel[i-1][j], r = plevel[i+1][j], u = plevel[i][j+1], d = plevel[i][j-1];
				stOgraj += t * (4 - l - r - u - d);
			}
		}

		System.out.println(stOgraj);
	}
}