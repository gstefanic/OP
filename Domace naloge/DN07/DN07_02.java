import java.util.*;
public class DN07_02 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		Scanner sc = new Scanner(System.in);
		int stNodes = sc.nextInt();
		int skupniCas = sc.nextInt();

		int[][] povezave = new int[stNodes][stNodes];
		boolean[][] b = new boolean[stNodes][stNodes];
		boolean[] preverjen = new boolean[stNodes];
		int[] najkrajsaPotDo = new int[stNodes];
		int[] prednik = new int[stNodes];
		for (int i = 0; i < stNodes; i++) {
			for (int j = 0; j < stNodes; j++) {
				povezave[i][j] = sc.nextInt();
			}
			najkrajsaPotDo[i] = Integer.MAX_VALUE;
			//najkrajsaPotDo[i] = povezave[0][i];
			//prednik[i] = -1;
		}

		najkrajsaPotDo[0] = 0;
		//prednik[0] = 0;

		posljiPismo(skupniCas, 0, najkrajsaPotDo, prednik, povezave, b);

		int stevec = 0;
		for (int i = 1; i < najkrajsaPotDo.length; i++) {
			if (najkrajsaPotDo[i] <= skupniCas) {
				stevec++;
			}
		}
		System.out.println(stevec);

		long stopTime = System.currentTimeMillis();
      	long elapsedTime = stopTime - startTime;
      	//System.out.println(elapsedTime);
	}

	public static void posljiPismo(int node, int preostaliCas, int[][] povezave, boolean[] jePrejel, int[][] najboljsiCas) {
		if (preostaliCas >= 0) {
			jePrejel[node] = true;
			for (int i = 0; i < povezave[node].length; i++) {
				int casDo = povezave[node][i];
				if (casDo != 0 && (najboljsiCas[node][i] == 0 || preostaliCas > najboljsiCas[node][i])) {
					najboljsiCas[node][i] = preostaliCas;
					posljiPismo(i, preostaliCas - casDo, povezave, jePrejel, najboljsiCas);
				}
			}
		}
	}

	public static void posljiPismo(int skupniCas, int node, int[][] povezave) {
		
	}

	public static void posljiPismo(int skupniCas, int node, int[] najkrajsaPotDo, int[] prednik, int[][] povezave, boolean[][] b) {
		for (int i = 0; i < povezave[node].length; i++) {
			int casDo = povezave[node][i];
			if ((casDo + najkrajsaPotDo[prednik[i]]) < najkrajsaPotDo[i]) {
				najkrajsaPotDo[i] = casDo + najkrajsaPotDo[prednik[i]];
				prednik[i] = node;				
			}
		}

		for (int i = 0; i < povezave[node].length; i++) {
			if (!b[node][i] && povezave[node][i] != 0 && (povezave[node][i] + najkrajsaPotDo[prednik[i]]) < skupniCas) {
				b[node][i] = true;
				posljiPismo(skupniCas, i, najkrajsaPotDo, prednik, povezave, b);
			}
		}
	}

	public static int naslednji(boolean[] preverjen, int[] najkrajsaPotDo, int prejsnjaDolzina) {
		int min = Integer.MAX_VALUE;
		int indexMin = -1;
		for (int i = 1; i < najkrajsaPotDo.length; i++) {
			if (!preverjen[i] && najkrajsaPotDo[i] >= prejsnjaDolzina && najkrajsaPotDo[i] < min) {
				min = najkrajsaPotDo[i];
				indexMin = i;
			}
		}
		if (indexMin != -1) {
			preverjen[indexMin] = true;
		}
		return indexMin;
	}

}