import java.util.*;
public class DN07_01 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		Scanner sc = new Scanner(System.in);
		int stNodes = sc.nextInt();
		int skupniCas = sc.nextInt();

		int[][] povezave = new int[stNodes][stNodes];
		for (int i = 0; i < stNodes; i++) {
			for (int j = 0; j < stNodes; j++) {
				povezave[i][j] = sc.nextInt();
			}
		}

		boolean[] jePrejel = new boolean[stNodes];

		posljiPismo(0, skupniCas, povezave, jePrejel);

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

	public static void posljiPismo(int node, int preostaliCas, int[][] povezave, boolean[] jePrejel) {
		if (preostaliCas >= 0) {
			jePrejel[node] = true;
			for (int i = 0; i < povezave[node].length; i++) {
				int casDo = povezave[node][i];
				if (casDo != 0) {
					posljiPismo(i, preostaliCas - casDo, povezave, jePrejel);
				}
			}
		}
	}
}