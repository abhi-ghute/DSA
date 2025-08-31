package search.binary;

//https://www.geeksforgeeks.org/dsa/find-rotation-count-rotated-sorted-array/
public class RotationCountInSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {7, 8, 6, 1, 2, 3, 4, 5, 6};
        System.out.println("without duplicate: " + findKRotation(nums1));

        int[] nums2 = {3, 3, 3, 3, 2};
        System.out.println("with duplicate: " + findKRotation(nums2));
    }

    //we can use the peak element method as well, but we need separate method for duplicates and not duplicates
    //in peak element method array is sorted in one direction it will return -1, so at the end it will be zero times rotated.
    static int findKRotation(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            // subarray is sorted and smallest is low
            if (arr[low] <= arr[high]) {
                return low;
            }

            int mid = (low + high) / 2;

            // Minimum is in the right half
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                // Minimum is in the left half (could be mid as well)
                high = mid;
            }
        }
        return low;
    }
}
