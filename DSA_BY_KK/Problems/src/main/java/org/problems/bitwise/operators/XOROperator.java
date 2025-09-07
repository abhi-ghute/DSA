package org.problems.bitwise.operators;

public class XOROperator {

    public static void main(String[] args) {
        int[] nums = {2,3,5,7,1,7,3,2,5};
        //same logic apply when even number of duplicates in array
        findUniqueElement(nums);
        System.out.println(xorFrom0ToN(10));
        System.out.println(xorFromAtoB(3,9));
    }

    // it will work on if each element is duplicated once only
    // and only one unique element is present
    static void findUniqueElement(int[] nums){
        int result = 0;
        for(int n: nums){
            result ^= n;
        }

        System.out.println(result);
    }

    //do the xor from 0 you will see this pattern is repeating
    public static int xorFrom0ToN(int n) {
        if (n % 4 == 0) return n;
        else if (n % 4 == 1) return 1;
        else if (n % 4 == 2) return n + 1;
        else return 0;
    }

    //first we will calculate xor for till b
    //then doing xor with a-1 will discard the xor values from b
    //as it will discard same bits in xor
    public static int xorFromAtoB(int a, int b) {
        return xorFrom0ToN(b) ^ xorFrom0ToN(a - 1);
    }
}
