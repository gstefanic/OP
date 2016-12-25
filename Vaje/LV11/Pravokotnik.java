import java.util.*;
public class Pravokotnik extends Lik {
	private int a;
	private int b;

	Pravokotnik(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return this.a;
	}

	public int ploscina() {
		return this.a * this.b;
	}

	public int obseg() {
		return this.a * 2 + this.b * 2;
	}

	public String toString() {
		return "pravokotnik [a = " + this.a + ", b = " + this.b + "]";
	}
}
