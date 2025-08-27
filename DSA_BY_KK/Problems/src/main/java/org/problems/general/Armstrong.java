package org.problems.general;

import java.util.Scanner;

/**
 * Armstrong numbers are defined only for non-negative integers.
 *
 * For an n-digit number: Let N=d1d2d3…dn
 * N=(d1)^n+(d2)^n+(d3)^n+…+(dn)^n
 *  - N is the number,
 *  - d1,d2,..dn are digits
 *  - n is number of digits in n
 *  So basically armstrong number is calculated by sum of each digit power(number of digits)
 *  0-9, 153, 9474...
 */
public class Armstrong {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter integer number: ");
        int num = sc.nextInt();
        boolean isArmstrong = isArmStrong(num);

        if (isArmstrong)
            System.out.println(num + " is Armstrong number.");
        else
            System.out.println(num + " is not Armstrong number.");
    }

    private static boolean isArmStrong(int num) {
       int digits = (int) Math.floor(Math.log10(num)) + 1; // to get number of digits
       int original = num;
       int result = 0;

        while (num > 0) {
            int digit = num % 10;
            result += power[digit][digits]; // use precomputed power
            num /= 10;
        }

        return result == original;
    }

    // Precompute powers of digits (0^1 to 9^10)
    static int[][] power = new int[10][11];

    static {
        for (int digit = 0; digit <= 9; digit++) {
            for (int exp = 1; exp <= 10; exp++) {
                power[digit][exp] = (int) Math.pow(digit, exp);
            }
        }
    }
}
