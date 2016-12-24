import java.util.*;
public class DN07_04 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		Scanner sc = new Scanner(System.in);
		int stNodes = sc.nextInt();
		int skupniCas = sc.nextInt();


		int[][] povezave = new int[stNodes][stNodes + 1];
		boolean[][] checked = new boolean[stNodes][stNodes];
		for (int i = 0; i < stNodes; i++) {
			int min = Integer.MAX_VALUE;
			int indexMin = 0;
			for (int j = 0; j < stNodes; j++) {
				int edge = sc.nextInt();
				if (edge != 0 && edge < min) {
					min = edge;
					indexMin = j;
				}
				povezave[i][j] = edge;
			}
			povezave[i][stNodes] = indexMin;
			checked[i][indexMin] = true;
		}

		boolean[] jePrejel = new boolean[stNodes];
		int[][] najboljsiCas = new int[stNodes][stNodes];

		posljiPismo(0, skupniCas, povezave, jePrejel, najboljsiCas, checked);

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

	public static void posljiPismo(int node, int preostaliCas, int[][] povezave, boolean[] jePrejel, int[][] najboljsiCas, boolean[][] checked) {
		if (preostaliCas > 0) {
			int shortestEdgeIndex = povezave[node][povezave[node].length - 1];
			//System.out.println(shortestEdgeIndex);
			jePrejel[node] = true;
			if (shortestEdgeIndex != 0 && (preostaliCas > najboljsiCas[node][shortestEdgeIndex])) {
				int min = Integer.MAX_VALUE;
				int indexMin = 0;
				int valueAtTmpMin = povezave[node][shortestEdgeIndex];
				for (int i = 0; i < jePrejel.length; i++) {
					if (povezave[node][i] != 0 && i != shortestEdgeIndex && povezave[node][i] >= valueAtTmpMin && povezave[node][i] < min && !checked[node][i]) {
						min = povezave[node][i];
						indexMin = i;
					}
				}
				if (min == Integer.MAX_VALUE) {
					return;
				}
				System.out.println("prejsni min: " + povezave[node][shortestEdgeIndex] + " novi: " + min);
				povezave[node][jePrejel.length] = indexMin;
				najboljsiCas[node][shortestEdgeIndex] = preostaliCas;
				posljiPismo(shortestEdgeIndex, preostaliCas - povezave[node][shortestEdgeIndex], povezave, jePrejel, najboljsiCas, checked);
			}
			jePrejel[node] = true;
			//posljiPismo(shortestEdgeIndex, preostaliCas - povezave[node][shortestEdgeIndex], povezave, jePrejel, najboljsiCas);
			for (int i = 0; i < povezave[node].length-1; i++) {
				int casDo = povezave[node][i];
				if (!checked[node][i] && casDo != 0 && (najboljsiCas[node][i] == 0 || preostaliCas > najboljsiCas[node][i])) {
					najboljsiCas[node][i] = preostaliCas;
					posljiPismo(i, preostaliCas - casDo, povezave, jePrejel, najboljsiCas, checked);
				}
			}
		} else if (preostaliCas == 0) {
			jePrejel[node] = true;
			return;
		}
	}
}