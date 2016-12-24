// 63160303
import java.util.*;
public class Zp {
    private int modul;

    // modul z intervala [2,97]
    public Zp(int modul) {
    	this.modul = modul;
    }

    public int vrniModul() {
    	return this.modul;
    }

    public String toString() {
    	return "Z_"+this.modul;
    }

    public int vsota(int prvo, int drugo) {
    	//return ((prvo+drugo)%this.modul);

    	int vsotaStevil = prvo + drugo;
    	if (vsotaStevil < this.modul) {
    		return vsotaStevil;
    	} else {
    		return vsotaStevil - this.modul;
    	}
    	/*

    	*/
    }

    public int zmnozek(int prvo, int drugo) {
    	return (prvo*drugo)%this.modul;
    }

    public int nasprotno(int stevilo) {
    	if (stevilo==0) {
    		return 0;
    	}
    	return (this.modul - stevilo);
    }

    public int razlika(int prvo, int drugo) {
    	return vsota(prvo, nasprotno(drugo));
    }

    public int obratno(int stevilo) {
    	
    	if (stevilo == this.modul-1 || stevilo == 1) {
    		return stevilo;
    	} 

    	int obratno = 1;
    	
    	while(obratno < this.modul) {
    		int zmnozek = stevilo*obratno;
    		if (zmnozek%this.modul == 1) {
    			return obratno;
    		}
    		obratno++;
    	}

    	return -1;
    }

    public int kolicnik(int prvo, int drugo) {
    	return zmnozek(prvo, obratno(drugo));
    }

    public int potenca(int stevilo, long eksponent) {
    	if (stevilo==0) {
    		return 0;
    	}

    	eksponent = eksponent%(this.modul-1);
    	if (eksponent==0) {
    		return 1;
    	} 
    	else if (eksponent>0) {
    		// binary shift
    		int dvojiskiEksponent = 1;
    		int toReturn = 1;
    		long tmp = eksponent;
    		while (tmp>0) {
    			if (tmp%2==1) {
    				toReturn *= exp2(stevilo, dvojiskiEksponent);
    				toReturn = toReturn%this.modul;
    			}
    			tmp /= 2;
    			dvojiskiEksponent *=2;
    		}
    		return toReturn;

    	} 
    	else {
    		return obratno(potenca(stevilo, -eksponent));
    	}
    }

	private int kvadrat(int stevilo) {
		return (stevilo*stevilo)%this.modul;
	}

	public int exp2(int osnova, long eksponent) {
		int stevec = 1;
		while (eksponent>1) {
			osnova = kvadrat(osnova)%this.modul;
			eksponent /= 2;;
			stevec++;
		}
		return osnova;
	}

    public int steviloKvadratnihKorenov(int stevilo) {
    	if (stevilo==0) {
    		return 1;
    	}

    	int stKorenov = 0;
    	for (int i = 1; i<this.modul; i++) {
    		int k = kvadrat(i);
    		if (k==stevilo) {
    			stKorenov++;
    		}
    	}

    	return stKorenov;
    }

    public boolean jeMultiplikativniGenerator(int stevilo) {
    	for (int i = 2; i<this.modul; i++) {
    		int potenca = potenca(stevilo, i);
    		if (stevilo == potenca) {
    			return false;
    		}
    	}

    	return true;
    }


}