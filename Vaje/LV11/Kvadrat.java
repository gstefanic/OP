import java.util.*;
public class Kvadrat extends Pravokotnik {

	Kvadrat(int a) {
		super(a, a);
	}

	@Override
	public String toString() {
		return "kvadrat [a = " + super.getA() + "]";
	}
}
