package sort.cyclic;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
//Google
//range 1 to n
public class FindAllMissingNumbers {

    public static void main(String[] args) {
        int[] nums = {4,5,1,1,5};
        System.out.println(findAllMissingNumbersUsingCyclicSort(nums));

        //optimal approach without sort
        System.out.println(findAllMissingNumbersUsingIndexingApproach(nums));
    }

    static List<Integer> findAllMissingNumbersUsingCyclicSort(int[] nums) {
        int i = 0;
        //perform cyclic sort first
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;

            if (nums[correctIndex] != nums[i]) {
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        //if current index element is not index+1 then that is duplicated
        //and index+1 is our missing number
        List<Integer> list = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }
        return list;
    }

    static List<Integer> findAllMissingNumbersUsingIndexingApproach(int[] nums) {
        //optimal solution without sort
        //updating nums array values to negative
        //if negative means number is duplicate
        // the using loop we will collect all positive numbers and return index+1

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            //this will ignore the number if already in negative, otherwise it be make positive
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        //after running above for loop it will mark all the index values with negative
        //except which are missing
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;

    }
}
