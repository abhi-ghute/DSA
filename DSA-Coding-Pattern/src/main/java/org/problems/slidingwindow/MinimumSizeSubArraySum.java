package org.problems.slidingwindow;

// https://leetcode.com/problems/minimum-size-subarray-sum/
// Given an array of positive numbers and a positive number S,
// find the length of the smallest contiguous subarray whose sum is greater than or equal to S.
public class MinimumSizeSubArraySum {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;

        int result1 = minSubArrayLen_BruteForce(nums, target);
        int result2 = minSubArrayLen(nums, target);

        System.out.println("Using BruteForce: " + result1);
        System.out.println("Using Sliding window: " + result2);
    }

    // Sliding Window approach (O(n))
    private static int minSubArrayLen(int[] nums, int target) {
        int n = nums.length;
        int minLength = n + 1;
        int sum = 0;
        int start = 0;

        // Expand window with 'end' and shrink from 'start' when sum >= target
        for (int end = 0; end < n; end++) {
            sum += nums[end];

            while (sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }

        return (minLength == n + 1) ? 0 : minLength;
    }

    // Brute Force approach (O(n^2))
    private static int minSubArrayLen_BruteForce(int[] nums, int target) {
        int n = nums.length;
        int minLength = n + 1;

        // Check sum of every possible subarray
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minLength = Math.min(minLength, j - i + 1);
                    break;
                }
            }
        }

        return (minLength == n + 1) ? 0 : minLength;
    }
}
