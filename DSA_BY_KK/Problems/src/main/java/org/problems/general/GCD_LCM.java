package org.problems.general;

//GCD(Greatest Common Divisor)/HCF(Highest Common Factor) and LCM(Least Common Multiple) program
public class GCD_LCM {

    public static void main(String[] args) {

        int a = 60;
        int b = 50;
        System.out.println("GCD of "+a+" "+b);

        System.out.println(gcdBruteForce(a,b));
        System.out.println(gcdEuclidean(a,b));

        System.out.println("LCM of "+a+" "+b);
        System.out.println(lcmBruteForce(a,b));
        System.out.println(lcmOptimal(a,b));
    }

    // Brute force method
    public static int gcdBruteForce(int a, int b) {
        int gcd = 1;
        int min = Math.min(a, b);

        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    // Optimal method using Euclidean algorithm
    //The GCD of two numbers a and b is the same as the GCD of b and a % b.
    //This is based on the principle:
    //If a = b × q + r, then GCD(a, b) = GCD(b, r)
    //(Where r is the remainder when a is divided by b)
    //so we can put it a and b in order
    public static int gcdEuclidean(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Brute force method to find LCM
    public static int lcmBruteForce(int a, int b) {
        int max = Math.max(a, b);

        while (true) {
            if (max % a == 0 && max % b == 0) {
                return max;
            }
            max++;
        }
    }

    //a×b=LCM(a,b)×GCD(a,b)
    public static int lcmOptimal(int a, int b) {
        return (a * b) / gcdEuclidean(a, b);
    }

}
