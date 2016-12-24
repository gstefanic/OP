// 63160149

public class Zp {
	
	private int modul;
	private int rezultat=1;
	
	public Zp(int modul) {
		this.modul = modul;
	}
	
	public int vrniModul() {
		return this.modul;
	}
	
	public String toString() {
		String a = "Z_"+this.modul;
		return a;
	}
	
	public int vsota(int prvo, int drugo) {
		return (prvo+drugo)%this.modul;
	}
	
	public int zmnozek(int prvo, int drugo) {
		return (prvo*drugo)%this.modul;
	}
	
	public int nasprotno(int stevilo) {
		if(stevilo==0)
			return 0;
		return this.modul-stevilo;
	}
	
	public int razlika(int prvo, int drugo) {
		return vsota(prvo, nasprotno(drugo));
	}
	
	public int obratno(int stevilo) {
		int a=1;
		while(zmnozek(stevilo, a)!=1){
			a++;
		}
		return a;
	}
	public int kolicnik(int prvo, int drugo) {
		return(zmnozek(prvo, obratno(drugo)));
	}
	
	public int potenca(int stevilo, long eksponent){
		long power=Math.abs(eksponent);
		int trenutno=stevilo;
		int steviloPotenc;
		if(eksponent==0)
			return 1;
		else if(eksponent==1){
			return stevilo%this.modul;
		}
		else if(eksponent==-1){
			return obratno(stevilo%this.modul);
		}
		else if(power>1){
			steviloPotenc=steviloPotenciranj(power);
			for(int i=0; i<steviloPotenc; i++)
				trenutno=potenciranje(trenutno, 2);
		}
		if(eksponent>0)
			return	zmnozek(trenutno, naslednjaPotenca(stevilo, dejanskaPotenca(power)));
		else
			return obratno(zmnozek(trenutno, naslednjaPotenca(stevilo, dejanskaPotenca(power))));
	}
	
	public int naslednjaPotenca(int stevilo, long eksponent){
		long power=Math.abs(eksponent);
		int trenutno=stevilo;
		int steviloPotenc;
		if(eksponent==0)
			return 1;
		else if(eksponent==1){
			return stevilo%this.modul;
		}
		else if(power>1){
			steviloPotenc=steviloPotenciranj(power);
			for(int i=0; i<steviloPotenc; i++)
				trenutno=potenciranje(trenutno, 2);
		}	
			return	zmnozek(trenutno, naslednjaPotenca(stevilo, dejanskaPotenca(power)));
	}
	
	private int steviloPotenciranj(long power){
		int trenutno=1;
		int stevec=0;
		while(trenutno*2<=power){
			trenutno = trenutno*2;
			stevec++;
		}
		return stevec;
		
	}
	
	private long dejanskaPotenca(long power){
		int trenutno=1;
		int stevec=0;
		while(trenutno*2<=power){
			trenutno = trenutno*2;
			stevec++;
		}
		return power-trenutno;
		
	}
	
	
	public int steviloKvadratnihKorenov(int stevilo) {
		int a=0;
		if(stevilo==0){
			return 1;
		}
		else{
			for(int i=1; i<modul; i++){
				if(zmnozek(i, i)==stevilo)
					a++;
			}
			return a;
		}		
	}
	
	public boolean jeMultiplikativniGenerator(int stevilo) {
		int a=0;
		int rezultatPotence;
		int [] tabela = new int[this.modul];
		if(stevilo==0)
			return false;
		else{
			for(int i=0; i<this.modul; i++){
				rezultatPotence=potenca(stevilo,i);
				tabela[rezultatPotence-1]=rezultatPotence;
			}
			for(int j=0; j<tabela.length; j++){
					if(tabela[j]!=0)
						a++;
				}
			if(a==this.modul-1)
				return true;
			else{
				return false;
			}
		}
	}
	
	public int potenciranje(int stevilo,long eksponent){
		if(eksponent == 0) {
			return 1;
		}			
		else if(eksponent>0){
			return zmnozek(stevilo, potenca(stevilo, eksponent-1));
		}
		return obratno(potenca(stevilo, -eksponent));
	}
	
}
