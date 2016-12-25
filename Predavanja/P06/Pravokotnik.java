public class Pravokotnik {
    private double a, b, x, y;

    // Konstruktorji
    Pravokotnik() {
    	this.a = 1;
    	this.b = 1;
    	this.x = 0;
    	this.y = 1;
    }

    Pravokotnik(double a, double b, double x, double y) {
    	this.a = a;
    	this.b = b;
    	this.x = x;
    	this.y = y;
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
    	return a*b;
    }

    public double obseg() {
    	return 2*(a+b);
    }

    public void premakni(double dx, double dy) {
    	this.x += dx;
    	this.y += dy;
    }

    public void izpisi() {
        System.out.printf("a=%f b=%f x=%f y=%f%n", a, b, x, y);
    	/*System.out.println(this.a);
    	System.out.println(this.b);
    	System.out.println(this.x);
    	System.out.println(this.y);*/
    }

    public String toString() {
    	return a + " " + b + " " + x + " " + y;
    }
}