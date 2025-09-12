package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {6,5,4,3,2,1,4};
        quickSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    // QuickSort function using Hoare partition scheme
    private static void quickSort(int[] arr, int low, int high) {

        // Base case: if the subarray has 0 or 1 element, it's already sorted
        if(low>=high){
            return;
        }

        int start = low; // Left pointer for sub array iteration
        int end = high;  // Right pointer for sub array iteration

        // Choose the middle element as pivot to avoid worst-case on sorted arrays
        int pivot = arr[start + (end - start) / 2];

        // Partitioning loop: move elements smaller than pivot to the left,
        // larger to the right
        while (start<= end){
            // also a reason to use quick sort if its already sorted it will not swap
            // Move start forward while elements are less than pivot
            while (arr[start]<pivot) start++;

            // Move end backward while elements are greater than pivot
            while (arr[end]>pivot) end--;

            // Swap elements if pointers haven't crossed
            if (start<= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        // Recursively sort the left and right subarrays
        quickSort(arr, low, end);   // Left half as end is before pivot
        quickSort(arr, start, high); // Right half as start is after pivot
    }
}
