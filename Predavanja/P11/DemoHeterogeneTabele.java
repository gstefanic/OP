public class DemoHeterogeneTabele {
	public static void main(String[] args) {
		Zival[] tz = new Zival[10];

		for (int i = 0; i < tz.length; i++) {
			if (i%3 == 0) {
				tz[i] = new Pes("Pes" + i);
			}
			else if (i%3 == 1) {
				tz[i] = new Macka("Macka" + i);
			}
			else {
				tz[i] = new Krava("Krava" + i);
			}
		}

		for (int i = 0; i < tz.length; i++) {
			tz[i].oglasanje();
		}
	}
}ž