public class DelavecOD {
    private int matSt;
    private String priimek, ime;
    private double[] osDoh;

    public DelavecOD(int matSt, String priimek, String ime, double[] osDoh) {
    	this.matSt = matSt;
    	this.priimek = priimek;
    	this.ime = ime;
    	// ustvarimo kopijo tabele
    	this.osDoh = osDoh.clone();
    }

    public double vsotaOD() {
    	int vsotaOD = 0;
    	for (int i = 0; i < this.osDoh.length; i++) {
    		vsotaOD += this.osDoh[i];
    	}
    	return vsotaOD;
    }

    public boolean zasluzilVec(DelavecOD d) {
    	return (this.vsotaOD()>d.vsotaOD());
    }

    public void izpisiVse() {
    	System.out.printf("%4d %-10s %-10s %10.2f%n", matSt, priimek, ime, this.vsotaOD());
    }
}