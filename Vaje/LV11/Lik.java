import java.util.*;
public abstract class Lik {

	public abstract int ploscina();

	public abstract int obseg();

	public abstract String toString();

	public void izpisi() {
		System.out.println(this.toString() + " | p = " + this.ploscina() + ", o = " + this.obseg());
	}
}
