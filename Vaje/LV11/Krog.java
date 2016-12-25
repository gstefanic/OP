import java.util.*;
public class Krog extends Lik {
	private int r;

	Krog(int r) {
		super();
		this.r = r;
	}

	public int ploscina() {
		return (int) Math.round( Math.PI * this.r * this.r );
	}

	public int obseg() {
		return (int) Math.round( Math.PI * this.r * 2 );
	}

	public String toString() {
		return "krog [r = " + this.r + "]";
	}

}
