import java.util.*;
public class DN07_03 {
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
		int[][] najboljsiCas = new int[stNodes][stNodes];
		boolean[] potrebnoPoslati = new boolean[stNodes];
		int[] casi = new int[stNodes];

		posljiPismo(0, skupniCas, povezave, jePrejel, najboljsiCas, potrebnoPoslati, casi);

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

	public static void posljiPismo(int node, int preostaliCas, int[][] povezave, boolean[] jePrejel, int[][] najboljsiCas, boolean[] potrebnoPoslati, int[] casi) {
		if (preostaliCas >= 0) {
			int tmpMin = Integer.MAX_VALUE;
			int tmpX = 0;
			jePrejel[node] = true;
			for (int i = 0; i < povezave[node].length; i++) {
				int casDo = povezave[node][i];
				if (casDo != 0 && (najboljsiCas[node][i] == 0 || preostaliCas > najboljsiCas[node][i])) {
					najboljsiCas[node][i] = preostaliCas;
					potrebnoPoslati[i] = true;
					casi[i] = casDo;
					if (casDo < tmpMin) {
						tmpMin = casDo;
						tmpX = i;
					}
				}
				else {
					potrebnoPoslati[i] = false;
					casi[i] = 0;
				}
			}

			posljiPismo(tmpX, preostaliCas - tmpMin, povezave, jePrejel, najboljsiCas, new boolean[povezave.length], new int[povezave.length]);


			for (int i = 0; i < potrebnoPoslati.length; i++) {
				if (potrebnoPoslati[i]) {
					posljiPismo(i, preostaliCas - casi[i], povezave, jePrejel, najboljsiCas, new boolean[povezave.length], new int[povezave.length]);
				}
			}
		}
	}
}