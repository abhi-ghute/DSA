package org.problems.bitwise.operators;

//same logic we can apply if odd number of duplicates present
//only modulus condition will change to bitcount % no of duplicates !=0
public class RightAndLeftShift {

    public static void main(String[] args) {
        int[] nums = {1,5,7,8,5,5,1,8,1,8};
        System.out.println(findUnique(nums));
    }

    public static int findUnique(int[] nums) {
        int result = 0;

        // Loop over each bit position (0 to 31 for int)
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;

            for (int num : nums) {
                //each time it will right shift number by i and if last bit is 1 it will increment bitCount
                //this performs addition of ith bit of every number
                if ((num >> i & 1) == 1) {
                    bitCount++;
                }
            }

            // If bitCount is not a multiple of 3, set this bit in result
            //if addition of each bit is not divisible by 3 then its not present in 3 times in array, so extra set bit(reminder)
            //is nothing but set bit of the unique number
            if (bitCount % 3 != 0) {
                //bitCount % 3 != 0 means this bit belongs to the unique number.
                //1 << i creates a number with only the i-th bit set.
                //result |= (1 << i) sets the corresponding bit in the result.
                //When i = 1:
                //(1 << 1) = 0010 = 2
                //result |= 2 → 1 | 2 = 0001 | 0010 = 0011 = 3
                result |= (1 << i);
            }
        }

        return result;
    }
}
