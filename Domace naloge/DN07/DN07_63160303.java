import java.util.*;
public class DN07_63160303 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		Scanner sc = new Scanner(System.in);
		int stNodes = sc.nextInt();
		int skupniCas = sc.nextInt();

		int[][] povezave = new int[stNodes][stNodes];
		int skupajMin = 0;
		for (int i = 0; i < stNodes; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < stNodes; j++) {
				int tmp = sc.nextInt();
				if (tmp < min) {
					min = tmp;
				}
				if (tmp + skupajMin <= skupniCas) {
					povezave[i][j] = tmp;
				}
			}
			skupajMin += min;
		}

		boolean[] jePrejel = new boolean[stNodes];
		int[][] najboljsiCas = new int[stNodes][stNodes];

		posljiPismo(0, skupniCas, povezave, jePrejel, najboljsiCas);

		int stevec = 0;
		for (int i = 0; i < stNodes; i++) {
			if (jePrejel[i] == true) {
				stevec++;
			}
		}
		System.out.println(stevec);

		long stopTime = System.currentTimeMillis();
      	long elapsedTime = stopTime - startTime;
      	//System.out.println(elapsedTime);
	}

	public static void posljiPismo(int node, int preostaliCas, int[][] povezave, boolean[] jePrejel, int[][] najboljsiCas) {
		if (preostaliCas > 0) {
			jePrejel[node] = true;
			for (int i = 0; i < povezave[node].length; i++) {
				int casDo = povezave[node][i];
				if (casDo != 0 && (najboljsiCas[node][i] == 0 || preostaliCas > najboljsiCas[node][i])) {
					najboljsiCas[node][i] = preostaliCas;
					posljiPismo(i, preostaliCas - casDo, povezave, jePrejel, najboljsiCas);
				}
			}
		} else if (preostaliCas == 0) {
			jePrejel[node] = true;
			return;
		}
	}
}