package org.problems.general;

public class NoOfDigitsInbinary {

    public static void main(String[] args) {

        int n = 10;
        int base = 2;

        //basically it is n = 2^x, which is logn with base 2 = x
        //x is ans, and logn base 2 is written as logn /log2;
        //its gives digits in double so we need to add+1
        int count = (int) (Math.log(n) / Math.log(base) +1);

        System.out.println(count);
    }
}
