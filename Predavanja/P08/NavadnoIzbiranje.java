public class NavadnoIzbiranje {
    public static void sort(int a[]) {
    	for(int i = 0; i <= a.length-2; i++) {
    		// inicializacija minimuma - za zacetno vrednost
    		// vzamemo kar prvi element: a[i]
    		int vMin = a[i];
    		// indeks minimuma
    		int iMin = i;

    		// v zanki pregledamo ostale elemente
    		for (int j = i+1; j<=a.length-1; j++) {
    			if (a[j]<vMin) {
    				vMin = a[j];
    				iMin = j;
    			}
    		}

    		// zamenjava a[i] in najmanjsega elementa
    		a[iMin] = a[i];
    		a[i] = vMin;
    	}
    }

    public static void main(String[] args) {
    	int[] a = {23, 78, 36, 12, 92, 46, 15, 65};
    	sort(a);

    	for (int  i = 0; i<a.length; i++) {
    		System.out.print(a[i]+" ");
    	}
    }
}