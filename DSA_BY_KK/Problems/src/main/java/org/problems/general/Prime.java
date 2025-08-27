package org.problems.general;

import java.util.Scanner;

public class Prime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num = sc.nextInt();

        boolean isPrime = isPrime(num);

        if (isPrime)
            System.out.println(num + " is prime number.");
        else
            System.out.println(num + " is not prime number.");
    }

    private static boolean isPrime(int num) {

        if (num <= 1) return false;  // 0 and 1 are not prime
        if (num <= 3) return true;   // 2 and 3 are prime

        // Eliminate multiples of 2 and 3 fast
        if (num % 2 == 0 || num % 3 == 0) return false;

        // Check only numbers of the form 6k ± 1 up to sqrt(n)
        // This works because all primes > 3 are of form 6k ± 1
        //i takes values like 5, 11, 17, 23, 29, ... (which are 6k - 1)
        //i + 2 takes values like 7, 13, 19, 25, 31, ... (which are 6k + 1)
        int limit = (int) Math.sqrt(num);
        for (int i = 5; i <= limit; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
