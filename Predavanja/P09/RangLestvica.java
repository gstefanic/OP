import java.util.*;
public class RangLestvica {
    public static void main(String[] args) {
    	DelavecOD[] td = preberiPodatke();
    	izpisiTabelo(td);
    	System.out.println();
    	urediTabelo(td);
    	izpisiTabelo(td);
    }

    public static DelavecOD[] preberiPodatke() {
    	DelavecOD[] td;
    	Scanner sc = new Scanner(System.in);
    	int stDel = sc.nextInt();
    	td = new DelavecOD[stDel];
    	for (int i = 0; i < stDel; i++) {
    		int matSt = sc.nextInt();
    		String priimek = sc.next();
    		String ime = sc.next();

    		double[] osDoh = new double[12];
    		// zanka za branje osebnih dohodkov
    		for (int j = 0; j < 12; j++) {
    			osDoh[j] = sc.nextDouble();
    		}

    		// kreiranje objekta
    		td[i] = new DelavecOD(matSt, priimek, ime, osDoh);
    	}
    	return td;
    }

    public static void izpisiTabelo(DelavecOD[] td) {
    	for (int i = 0; i < td.length; i++) {
    		td[i].izpisiVse();
    	}
    }

    public static void urediTabelo(DelavecOD[] td) {
    	for (int i = 0; i < td.length-1; i++) {
    		// inicializacija trenutnega maksimuma
    		DelavecOD vMax = td[i];
    		int iMax = i;

    		// korekcija trenutnega maksimuma
    		for (int j = i+1; j < td.length; j++) {
    			if (td[j].zasluzilVec(vMax)) {
    				vMax = td[j];
    				iMax = j;
    			}
    		}
    		td[iMax] = td[i];
    		td[i] = vMax;
    	}
    }
}