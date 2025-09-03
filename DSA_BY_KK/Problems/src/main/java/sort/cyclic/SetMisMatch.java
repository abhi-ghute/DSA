package sort.cyclic;

import java.util.Arrays;

//https://leetcode.com/problems/set-mismatch/
/*
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.
Input: nums = [1,2,2,4]
Output: [2,3]
Input: nums = [1,1]
Output: [1,2]
* */
public class SetMisMatch {

    public static void main(String[] args) {
        int[] nums = {1,2,2,4};

        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {

        int i = 0;
        //cyclic sort
        while(i<nums.length){
            int correctIndex = nums[i] - 1;

            if(nums[correctIndex] != nums[i]){
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            }
            else{
                i++;
            }
        }

        //iterate and find index where element is wrong placed
        //that means the element in that index(which is repeated)and index+1 are the missed element as we starting from 1
        //
        for(i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                return new int[] {nums[i], i+1};
            }
        }

        return new int[] {-1,-1};
    }
}
