package search.twodarray;

import java.util.Arrays;

//which means next element is greater or equal to current
public class SearchInStrightlySortedArray {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 30;

        System.out.println(Arrays.toString(searchMatrix(matrix, target)));
    }

    static int[] searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midElement = matrix[mid / cols][mid % cols];

            if (midElement == target) {
                return new int[]{mid / cols, mid % cols};
            } else if (midElement < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[]{-1, -1};

    }
}
