package org.problems.bitwise.operators;

public class LeftShiftOperator {
    public static void main(String[] args) {
        setIthBit(4, 4);
        resetIthBit(6,3);
    }

    //set means set ith bit as 1
    //to set ith bit we need to move i by i-1 to left position
    //if 1 is as at first position then we need to left shift it by i-1
    static void setIthBit(int n, int i) {
        System.out.println(n | (1 << i-1));
    }

    //(1 << (i - 1)) — creates a mask with a 1 at the i-th bit position.
    //~(1 << (i - 1)) — flips bits, so all are 1 except the i-th bit is 0.
    //number & ... — clears the i-th bit (sets it to 0) while leaving other bits unchanged.
    static void resetIthBit(int n, int i) {
        System.out.println( n & ~(1 << (i - 1)));
    }
}
