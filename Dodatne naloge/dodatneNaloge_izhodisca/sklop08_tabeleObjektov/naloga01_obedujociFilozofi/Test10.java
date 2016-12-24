
import java.util.*;

public class Test10 {

    public static void main(String[] args) {
        Filozof a = new Filozof();
        a.nastaviSoseda(a, a);
        System.out.println(a.steviloFilozofov());
    }
}
