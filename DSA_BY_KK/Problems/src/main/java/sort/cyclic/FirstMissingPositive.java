package sort.cyclic;

//https://leetcode.com/problems/first-missing-positive/
//cyclic sort
/*
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
*/
//we will ignore negative numbers, zero and numbers greater than our array length
//after performing cyclic sort if i+1 is not the element its containing then that's the first missing number
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {-7,8,9,11,12};
        System.out.println(firstMissingPositiveUsingCyclicSort(nums));
    }

    public static int firstMissingPositiveUsingCyclicSort(int[] nums) {

        //cyclic sort
        int i = 0;
        while(i<nums.length){
            int correctIndex = nums[i]-1;
            //skip less than or equal to 0 as no need to consider
            //skip num greater than array length as we need to find out first missing int
            if(nums[i]>0 && nums[i] <= nums.length && nums[correctIndex] != nums[i]){
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            }else{
                i++;
            }
        }

        //after cyclic sort if i+1 is not same as nums[i]
        //then i+1 is first missing int
        for(i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }

        //if above if is not satisfied then array is sorted with 1 to N
        //thats why first missing number is n+1
        return nums.length+1;
    }
}
