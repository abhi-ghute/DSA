package sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        //less efficient
        int[] result = mergeSort(arr);

        inPlaceMergeSort(arr, 0, arr.length);

        System.out.println("Traditional Merge sort: "+ Arrays.toString(result));
        System.out.println("In place Merge sort: "+ Arrays.toString(arr));
    }

    //in this one we will just keep track of start and end
    // after getting start and end for each subarray we will sort subarray first using temp array and then store back to original array
    // we will follow this process until we get whole array sorted
    private static void inPlaceMergeSort(int[] arr, int start, int end) {
        // Base case: if subarray has 1 or 0 elements, it's already sorted
        if (end - start <=1) {
            return;
        }

        // Calculate the midpoint of the current subarray
        int mid = start + (end - start) / 2;

        // Recursively sort the left half: [start, mid)
        inPlaceMergeSort(arr, start, mid);

        // Recursively sort the left half: [start, mid)
        inPlaceMergeSort(arr, mid, end);

        // Merge the two sorted halves in-place
        mergeInplace(arr, start,mid, end);
    }


    //start to mid-1 =>left array sorted
    //mid to end-1 =>right array sorted
    //we merge them with the help of temp array
    private static void mergeInplace(int[] arr, int start, int mid, int end) {
        // Temporary array to store merged result of the two halves
        int[] tempResult = new int[end - start];

        // i → pointer for left half (start to mid - 1)
        // j → pointer for right half (mid to end - 1)
        // k → index for tempResult
        int i = start;
        int j = mid;
        int k = 0;

        // Compare elements from both halves and merge them into tempResult[]
        while(i<mid && j<end){
            if(arr[i] < arr[j]){
                tempResult[k] = arr[i];
                i++;
            }else {
                tempResult[k] = arr[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (i < mid) {
            tempResult[k++] = arr[i++];
        }

        while (j < end) {
            tempResult[k++] = arr[j++];
        }

        // Copy the sorted merged result back into the original array
        for (int l = 0; l < tempResult.length; l++) {
            //start+1 means we are just placing from where subarray starts not from 0th
            arr[start+l] = tempResult[l];
        }

    }

    //This is less efficient as we need to create the left and right arrays copy for each iteration
    //Recursively divides and sorts the array using merge sort algorithm.
    //it returns new sorted array for each recursion call
    private static int[] mergeSort(int[] arr) {

        // array of 0 or 1 elements is already sorted or empty
        if (arr.length <= 1) {
            return arr;
        }

        // Find the midpoint to divide the array
        int mid = arr.length / 2;

        // Recursively sort the left half of the array until all left part is sorted
        int[] leftSorted = mergeSort(Arrays.copyOfRange(arr, 0, mid));

        // Recursively sort the right half of the array till last element
        int[] rightSorted = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        // Merge the two sorted halves and return the result
        return mergeSortedArrays(leftSorted, rightSorted);
    }

    //Merges two sorted arrays into a single sorted array.
    //leftSorted  The first sorted array
    //rightSorted The second sorted arra
    //return A new merged and sorted arrayy
    private static int[] mergeSortedArrays(int[] leftSorted, int[] rightSorted) {

        // Indices
        int i = 0; // leftSorted
        int j = 0; // rightSorted
        int k = 0; // result array

        // Create a new array to hold the merged result
        int[] result = new int[leftSorted.length + rightSorted.length];

        // Merge the two arrays while both have elements remaining
        while (i < leftSorted.length && j < rightSorted.length) {

            // Compare elements and add the smaller one to the result array
            if (leftSorted[i] < rightSorted[j]) {
                result[k] = leftSorted[i];
                i++; //inserted ith element
            } else {
                result[k] = rightSorted[j];
                j++; //inserted jth element
            }
            k++; //always because any one of condition will run
        }

        // Copy any remaining elements from leftSorted
        while (i < leftSorted.length) {
            result[k++] = leftSorted[i++];
        }

        // Copy any remaining elements from rightSorted
        while (j < rightSorted.length) {
            result[k++] = rightSorted[j++];
        }

        return result;
    }


}
