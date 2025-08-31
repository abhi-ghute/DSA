package search.binary;

//https://leetcode.com/problems/split-array-largest-sum/
//Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
//so it should split it into k and returns the min(largest sum) from all the list of sum.
public class SplitArrayLargestSum {

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;

        System.out.println(splitArray(nums,k));
    }
    public static int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num); // min possible max sum
            high += num;              // max possible max sum
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Try to split array with max sum = mid
            if (canSplit(nums, k, mid)) {
                high = mid; // Try smaller max sum
            } else {
                low = mid + 1; // Try bigger max sum
            }
        }

        return low; // or high (both are equal here)
    }

    private static boolean canSplit(int[] nums, int k, int maxSumAllowed) {
        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSumAllowed) {
                subarrays++;
                currentSum = num;
                if (subarrays > k) return false;
            } else {
                currentSum += num;
            }
        }
        return true;
    }
}
