package org.problems.slidingwindow;

//https://leetcode.com/problems/maximum-average-subarray-i/
public class MaximumAverageSubArray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 3, 3};
        int k = 4;

        double result1 = findMaxAverage_BruteForce(nums, k);
        double result2 = findMaxAverage(nums, k);

        System.out.println("Using BruteForce:" + result1);
        System.out.println("Using Sliding window:" + result2);
    }

    private static double findMaxAverage(int[] nums, int k) {
        double result;
        long sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        result = (double) sum / k;

        for (int i = 1; i < nums.length - k + 1; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];

            result = Math.max(result, (double) sum / k);
        }

        return result;
    }

    private static double findMaxAverage_BruteForce(int[] nums, int k) {
        double result = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < nums.length - k + 1; i++) {
            double average = 0;
            long sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }

            average = (double) sum / k;

            result = Math.max(result, average);
        }
        return result;
    }
}
