package recursion;

//nth fibo number
public class FibonacciNumber {

    public static void main(String[] args) {

        System.out.println(fibonacciNumber(6));
    }

    static int fibonacciNumber(int n){
        if(n < 2){
            return n;
        }
        return fibonacciNumber(n-1) + fibonacciNumber(n-2);
    }
}
