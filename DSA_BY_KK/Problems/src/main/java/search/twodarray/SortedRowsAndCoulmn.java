package search.twodarray;

import java.util.Arrays;

public class SortedRowsAndCoulmn {

    public static void main(String[] args) {

        int[][] nums = {
                {60, 70, 80, 90},
                {61, 71, 81, 92},
                {66, 74, 85, 98},
                {91, 95, 98, 99}
        };
        int target = 85;

        System.out.println(Arrays.toString(searchInSortedRowAndColumn(nums, target)));
    }

    static int[] searchInSortedRowAndColumn(int[][] nums, int target) {
        int row = 0;
        int col = nums.length - 1;

        while (row < nums.length && col >= 0) {
            if (nums[row][col] == target) {
                return new int[]{row, col};
            }

            if (nums[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return new int[]{-1, -1};
    }
}
