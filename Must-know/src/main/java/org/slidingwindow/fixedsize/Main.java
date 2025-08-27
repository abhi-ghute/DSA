package org.slidingwindow.fixedsize;

public class Main {
    public static void main(String[] args) {
        System.out.println("Maximum sum of subarray");

        int[] arr = {9,5,6,13,8,20};
        System.out.println("maximumSumOfSubArray:"+
                MaximumSumOfSubArray.maxSumSubarray(arr,2));

        int[] firstNegatieAray = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        System.out.println("firstNegativeFromWindow:"+
                FirstNegativeInWindow.firstNegativeInWindow(firstNegatieAray, k));

        int[] maxFromSlidingWindow = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println("maxFromSlidingWindow:"+
                MaxFromSlidingWindow.maxFromSlidingWindow(maxFromSlidingWindow, k));
    }
}