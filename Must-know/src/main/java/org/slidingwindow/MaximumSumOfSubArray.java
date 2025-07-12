package org.slidingwindow;

public class MaximumSumOfSubArray {

    public static int maxSumSubarray(int[] arr, int k){
        int maxSum = 0, windowSum = 0;

        for(int i=0;i<k;i++){
            windowSum +=arr[i];
        }

        for(int i=k;i<arr.length;i++){
            windowSum +=arr[i]-arr[i-k];
            maxSum = Math.max(windowSum,maxSum);
        }
        return maxSum;
    }
}
