package search.binary;

//rotated sorted array mens after/before large element all should be smaller or equal
public class RotatedSortedAWithDulpicate {

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 3, 2};
        int target = 2;

        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        //same logic which for without duplicate
        int pivot = peakElementIndex(nums);
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        } else if (nums[pivot] == target) {
            return pivot;
        } else if (target < nums[0]) {
            //if target is less then it present before pivot
            return binarySearch(nums, target, pivot + 1, nums.length - 1);
        } else {
            return binarySearch(nums, target, 0, pivot - 1);
        }
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int peakElementIndex(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            //if any of element is greater than next or prev element then that's the peak
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            // If elements at start, mid, end are equal — skip duplicates
            if (nums[start] == nums[mid] && nums[end] == nums[mid]) {
                // Skip duplicates safely
                //we are checking as start is greater than next then condition satisfied
                if (start < end && nums[start] > nums[start + 1]) {
                    return start;
                }
                //to remove duplicate
                start++;

                //we are checking as previous is greater than end then condition satisfied
                if (end > start && nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                //to remove duplicate
                end--;
            }
            // Left side is sorted — go right
            else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                //mid+1 because we already checked it with mid
                //here we are doing +1 as mid will not be our pivot or there is no chances it should present on left side
                //as we are checking start and mid are equal or not, if its equal all element before start is same as mid
                //if mid is not greater than end there will be present in left part then
                start = mid + 1;
            }
            // Right side is sorted — go left
            else {
                //mid-1 because we already checked it with mid
                //we will go in left side as mid is greater or equal to end
                end = mid - 1;
            }
        }
        return -1;
    }
}
