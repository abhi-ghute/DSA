package org.problems.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Prime {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
////        System.out.println("Enter number: ");
        int num = 17;

        boolean isPrime = isPrime(num);

        if (isPrime)
            System.out.println(num + " is prime number.");
        else
            System.out.println(num + " is not prime number.");

        System.out.println(sieve(30));
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
        //we will do till less than equal to sqrt(num) because after that all the
        //numbers will get repeated like for 36 ->1*36,2*18,3*12,4*9,6*6 after this all will get reversed like 18*2 or 9*4
        int limit = (int) Math.sqrt(num);
        //instead we can also write i*i<=limit which is same square on both side, instead of sqrt
        for (int i = 5; i <= limit; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    //Steps of the Sieve of Eratosthenes
    //Example: Find all primes ≤ 30
    //Create a list from 2 to n (in this case, 2 to 30).
//    Start with the first prime number, 2.
//    Mark all multiples of 2 (except 2 itself) as non-prime.
//    Move to the next unmarked number, which is 3, and mark all multiples of 3.
//    Repeat this process for the next unmarked number (5, then 7, etc.), until you've processed numbers up to √n.
//    All remaining unmarked numbers are prime.
    public static List<Integer> sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];//we will do it because need to consider last n/30 as well

        //considering if isprime[i] is false then prime otherwise not prime
        for (int p = 2; p * p <= n; p++) {
            if (!isPrime[p]) {
                // Mark all multiples of p as non-prime which means true
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = true; // marking number as true if it is divisible
                }
            }
        }

        // Collect all prime numbers
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            //if number is false means that is prime as divisible numbers marked as true
            if (!isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

}
