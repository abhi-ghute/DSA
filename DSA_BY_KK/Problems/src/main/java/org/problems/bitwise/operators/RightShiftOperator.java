package org.problems.bitwise.operators;

public class RightShiftOperator {

    public static void main(String[] args) {

        findIthBitOfNumber(29, 5);

        //magic number is sum of each bit in binary * 5^i
        //n = 6 =>110
        //Calculate sum:
        //0*5^1 = 0
        //1*5^2 = 25
        //1*5^3 = 125
        findNthMagicNumber(5);

        // it will work for any power
        System.out.println(fastPower(5, 3));
    }

    private static void findIthBitOfNumber(int n, int i) {
        // it will shift all the i-1 digits to right after ith, basically remove
        // so after right shift our ith number at last position
        //if we & with 1 it will give the last bit and all other bits will be 0 as binary of 1 is (0000)1 only
        //11101 after shift by 5,1 and 1&1 will be 1 for i 2, result will be 0
        System.out.println((n >> i - 1) & 1);
    }

    private static void findNthMagicNumber(int n) {

        int ans = 0;
        int base = 5;

        while (n > 0) {
            int lastBit = n & 1;
            n = n >> 1;
            ans += base * lastBit;
            base = base * 5;
        }

        System.out.println(ans);
    }

    public static long fastPower(int a, int b) {
        int base = a;
        long result = 1;

        //3 power 3 =>011 base =>3=> 3*1=>result 3
        //base 9 =>result * base =>result 27->then b is 0
        while (b > 0) {
            //if last bit is one we will multiply base with result
            if ((b & 1) == 1) {
                result *= base;
            }

            //for every bit multiply base with itself
            base *= base;

            //discard last bit
            b = b >> 1;
        }

        return result;
    }
}
