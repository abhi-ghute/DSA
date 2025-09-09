package recursion;

public class Level1Questions {

    public static void main(String[] args) {

        System.out.println("Number of zeros in N(300304102) : "+numberOfZeros(300304102));

        System.out.println("-------------------------------------");
        System.out.println("reverse N(67862) : "+reverseNumber(67862));

        System.out.println("-----------------------------------");
        System.out.println("sum of N(3421) digits: " + sumOfDigits(3421));
        System.out.println("product of N(3421) digits: " + productOfDigits(3421));

        System.out.println("------------------------------------");
        System.out.println("sum of 1 to 10 : " + sumOf1toN(10));

        System.out.println("------------------------------------");
        System.out.println("Factorial of 5: " + factorial(6));
        System.out.println("------------------------------------");

        System.out.println("1 to N or N to 1:");
        nto1(6);
        System.out.println();
        o1ton(6);
        System.out.println();
        Nto1And1toN(6);
        System.out.println("\n------------------------------------");

    }

    private static int numberOfZeros(int n) {
        return numberOfZerosHelper(n, 0);
    }

    static int numberOfZerosHelper(int n, int count){
        if(n == 0){
            return count;
        }

        if(n%10 == 0){
            return numberOfZerosHelper(n/10, count+1);
        }

        return numberOfZerosHelper(n/10,count);
    }



    //we can do it in others ways also like storing sum in class level variable
    static long reverseNumber(int n) {
        return reverseNumberHelper(n,0);
    }

    static long reverseNumberHelper(int n, int reversed){
        if (n == 0) return reversed;
        return reverseNumberHelper(n/10,(10*reversed)+n%10);
    }

    static long productOfDigits(int n) {
        if (n % 10 == n) return n;
        //% and / haas same precedence from left to right so use it wisely
        return productOfDigits(n / 10) * (n % 10);
    }


    static long sumOfDigits(int n) {
        if (n <= 0) return 0;

        return sumOfDigits(n / 10) + n % 10;
    }

    static long sumOf1toN(int n) {
        if (n == 1) return 1;

        return n + sumOf1toN(n - 1);
    }

    static long factorial(int n) {
        if (n == 1) return 1;

        return n * factorial(n - 1);
    }

    static void nto1(int n) {
        if (n == 0) return;

        System.out.print(n + " ");
        nto1(n - 1);
    }

    static void o1ton(int n) {
        if (n == 0) return;

        o1ton(n - 1);
        System.out.print(n + " ");
    }

    static void Nto1And1toN(int n) {
        if (n == 0) {
            System.out.println();
            return;
        }

        System.out.print(n + " ");
        Nto1And1toN(n - 1);
        System.out.print(n + " ");
    }
}
