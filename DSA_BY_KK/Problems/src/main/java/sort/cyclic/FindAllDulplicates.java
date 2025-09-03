package sort.cyclic;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-duplicates-in-an-array/
//amazon/microsoft
//cyclic sort 1 to n
public class FindAllDulplicates {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicatesUsingCyclicSort(nums));
    }

    public static List<Integer> findDuplicatesUsingCyclicSort(int[] nums) {

        int i = 0;
        List<Integer> list = new ArrayList<>();

        while (i < nums.length) {
            int correctIndex = nums[i] - 1;

            if (nums[correctIndex] != nums[i]) {
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            } else {
                // if we add duplicate check here, it might get same duplicate add multiple times
                i++;
            }
        }

        // After sorting, any index i where nums[i] != i + 1 is a duplicate
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                list.add(nums[j]);
            }
        }
        return list;
    }
}
