package org.problems.bitwise.operators;

public class AndOperator {

    public static void main(String[] args) {
        isEvenOrOdd(11);
        findRightMostSetBit(16);
        System.out.println(isPowerOfTwo(18));

        System.out.println(Integer.toBinaryString(430) +" no of set bits in 112 is "+
                countSetBits(430));
    }

    static void isEvenOrOdd(int n){
        //binary of 1 is 1 so it will only check last digit
        //if any binary LSB (least significant bit - number ends) with 1 is odd else even
        //so & with 1 will no impact on last digit, but if its even it will make it as 0
        //we can same check with xor as well
        if((n&1) == 1){
            System.out.println("Number is ODD");
        }else {
            System.out.println("Number is Even");
        }
    }

    //In binary, -n is the two's complement of n.
    //n & -n leaves only the lowest set bit as 1, all others as 0.
    //n      = 0001 0010   // decimal 18
    //~n     = 1110 1101   // invert bits
    //-n     = 1110 1101 + 1 = 1110 1110   // two's complement
    //n & -n = 0001 0010 & 1110 1110 = 0000 0010  // result = 2
    static void findRightMostSetBit(int n){
        //| Expression                              | Meaning                    |
        //| --------------------------------------- | -------------------------- |
        //| n & -n                                | Value of rightmost set bit |
        //| Integer.numberOfTrailingZeros(n & -n) | Position (0-based)         |
        //| +1 after that                         | Position (1-based)         |
        if (n == 0) {
            System.out.println("No set bits.");
        } else {
            int pos = Integer.numberOfTrailingZeros(n & -n) + 1;
            System.out.println("Decimal value of rightmost set bit: "+ (n&-n));
            System.out.println("Rightmost set bit is at position: " + pos);
        }
        //int n = 18;          // binary: 10010
        //int x = n & -n;      // binary: 00010 → decimal 2
        //Integer.numberOfTrailingZeros(x) → counts how many 0s are to the right of that set bit:
        //Integer.numberOfTrailingZeros(2) = 1
        //+1 → because bit positions are 1-based, not 0-based.
    }

    //so it will ignore numbers less than or equal to 1
    //as lowest power of 2 is 1
    // as binay will contain only 1 if it is power of 2
    //we will subtract 1 from it will give all 1
    //so & with all 1 discard all 1's
    //ex: 4 ->0100 ->4-1 =>0011=> 0100 & 0011=>0
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    //Subtracting 1 from n flips the rightmost set bit and all bits to the right.
    //Then, n & (n - 1) clears the rightmost set bit.
    //n        = 1101 (13)
    //n - 1    = 1100 (12)
    //n & (n-1)= 1100   ← rightmost 1 cleared
    //same will be done till 0
    //Brian Kernighan’s Algorithm
    public static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // clear the rightmost set bit
            count++;
        }
        //Integer.bitCount(n);
        return count;
    }

}
