public class Fibonacci {
    int a, b;

    Fibonacci(int a, int b) {
    	this.a = a;
    	this.b = b;
    }

    public int naslednji(){
        int toReturn = a + b;
        this.a = b;
        this.b = toReturn;
        return toReturn;
    }
}