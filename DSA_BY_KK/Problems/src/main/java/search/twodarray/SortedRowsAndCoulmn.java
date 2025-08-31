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

            //num is same as target
            if (nums[row][col] == target) {
                return new int[]{row, col};
            }

            //it will reduce the number of rows and columns
            if (nums[row][col] < target) {
                //it num is less than target then it should be in next row
                //as all previous element in that row are less than number as row is sorted
                row++;
            } else {
                //it num is greater than target then it should not in that col
                //as all next element in that col are greater than number as col is sorted
                col--;
            }
        }
        return new int[]{-1, -1};
    }
}
