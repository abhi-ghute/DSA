package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

//it will bubble up the largest element at then end
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Outer loop for each pass
        for (int i = 0; i < n - 1; i++) {
            swapped = false;  // swap set to false for next pass

            // Inner loop goes from index 1 to (n - i - 1) as after that all element are in correct position
            for (int j = 1; j < n - i; j++) {
                // Compare current element with the previous one
                if (arr[j] < arr[j - 1]) {
                    // Swap if they're in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;  // Mark if any swap occurred
                }
            }

            // If no swaps happened in current pass, the array is sorted
            //we are avoiding next iterations early if array is sorted and no swap needed
            if (!swapped) return;
        }
    }
}
