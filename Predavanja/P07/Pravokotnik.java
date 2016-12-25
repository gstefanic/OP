public class Pravokotnik {
    private double a, b, x, y;

    // dodati zelimo stetje kreiranje pravokotnikov
    // ena sama samostojna spremenljivka, ki obstaja
    // neodvisno od objektov - uporabimo dolocilo static
    private static int stPravokotnikov = 0;

    // stevec stPravokotnikov povecujemo v konstruktorjih

    // Konstruktorji
    Pravokotnik() {
    	this.a = 1;
    	this.b = 1;
    	this.x = 0;
    	this.y = 1;
        stPravokotnikov++;
    }

    Pravokotnik(double a, double b, double x, double y) {
    	this.a = a;
    	this.b = b;
    	this.x = x;
    	this.y = y;
        stPravokotnikov++;
    }

    // deklaracija metode za vracanje vrednosti stevca stPravokotnikov
    public static int vrniStPravokotnikov() {
        return stPravokotnikov;
    }

    // Metode
    public void nastaviVelikost(double a, double b) {
    	this.a = a;
    	this.b = b;
    }

    public void nastaviLego(double x, double y) {
    	this.x = x;
    	this.y = y;
    }

    public double ploscina() {
    	return this.a*this.b;
    }

    public double obseg() {
    	return 2*(this.a+this.b);
    }

    public void premakni(double dx, double dy) {
    	this.x += dx;
    	this.y += dy;
    }

    public void izpisi() {
        System.out.printf("a=%f b=%f x=%f y=%f%n", this.a, this.b, this.x, this.y);
    	/*System.out.println(this.a);
    	System.out.println(this.b);
    	System.out.println(this.x);
    	System.out.println(this.y);*/
    }

    public String toString() {
    	return this.a + " " + this.b + " " + this.x + " " + this.y;
    }
}