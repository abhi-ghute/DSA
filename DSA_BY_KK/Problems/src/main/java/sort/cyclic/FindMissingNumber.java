package sort.cyclic;

//https://leetcode.com/problems/missing-number/
//amazon
//it should be in range, we should know the start
//below example uses 0 to N
public class FindMissingNumber {
    public static void main(String[] args) {
        int[] nums = {1,5,0,2,3};
        System.out.println(findMissingNumberUsingCyclicSort(nums));

        //optimal approach with sum of numbers if it's starting from 0 or 1
        System.out.println(findMissingNumberUsingSum(nums));

        //or using x-or which is also optimal
        System.out.println(findMissingNumberUsingSum(nums));
    }

    static int findMissingNumberUsingCyclicSort(int[] nums) {
        //cyclic sort approach
        //use xor or sum appraoch
        //this is taking much time that previous
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i];
            if (correctIndex < nums.length && i != correctIndex) {
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    //this need number starting for 0 or n only
    static int findMissingNumberUsingSum(int[] nums){
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    static int findMissingNumberUsingXOR(int[] nums){
        //x-or approach
         int xor = 0, n = nums.length;
         for (int i = 0; i < n; i++) {
             xor ^= i ^ nums[i];
         }
         return xor ^ n;
    }
}
