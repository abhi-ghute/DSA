package search.binary;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/
//https://leetcode.com/problems/find-peak-element/
//https://leetcode.com/problems/find-in-mountain-array/ + orderAgnostic search

//this is the array it will increase first and after peak it will start decreasing
//it will not contain duplicate
public class BitonicArray {

    public static void main(String[] args) {
        int[] nums = {0, 10, 5, 2};

        System.out.println(findPeakElement(nums));
        System.out.println(isValidBitonic(nums));
    }

    // this is to search the element and this is for leetcode problems
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        //we are not using equal as we are using mid+1
        //so if start and end is at same then thats the peak.
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // We're in the increasing part
                //so start will be mid+1 as mid is already less that mid+1
                start = mid + 1;
            } else {
                // We're in the decreasing part
                //mid can be the peak element so we are considering mid as well
                end = mid;
            }
        }

        return start; // or end, both are same here
    }

    // this just for check
    public static boolean isValidBitonic(int[] arr) {
        int n = arr.length;

        if (n < 3) return false; // Bitonic array needs at least 3 elements

        int i = 1;

        //check increasing firs
        while (i < n && arr[i] > arr[i - 1]) {
            i++;
        }

        // no increasing
        if (i == 1 || i == n) return false;

        // check decreasing
        while (i < n && arr[i] < arr[i - 1]) {
            i++;
        }

        // if we reach at end its increasing and then decreasing
        return i == n;
    }
}
