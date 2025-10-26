package org.problems.slidingwindow;

// Given an array of positive numbers and a positive number K,
// find the maximum sum of any contiguous subarray of size K
// https://leetcode.com/problems/largest-subarray-length-k/description/
public class MaximumSumSubArray {

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;

        long result1 = finMaximumSumSubArray_BruteForce(nums, k);
        long result2 = finMaximumSumSubArray(nums, k);

        System.out.println("Using BruteForce: " + result1);
        System.out.println("Using Sliding window: " + result2);
    }

    // Sliding Window Approach (O(n))
    private static long finMaximumSumSubArray(int[] nums, int k) {
        long maxSum = 0;
        // Calculate sum of first window
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        long windowSum = maxSum;

        // Slide the window from start to end of array
        for (int i = 1; i < nums.length - k + 1; i++) {
            windowSum = windowSum + nums[i + k - 1] - nums[i - 1];
            maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum;
    }

    // Brute Force Approach (O(n * k))
    private static long finMaximumSumSubArray_BruteForce(int[] nums, int k) {
        long maxSum = 0;

        // Check sum of every possible subarray of size k
        for (int i = 0; i < nums.length - k + 1; i++) {
            long sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
}
