package org.problems.bitwise.operators;

public class AndOperator {

    public static void main(String[] args) {
        int n = 11;
        isEvenOrOdd(n);
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
}
