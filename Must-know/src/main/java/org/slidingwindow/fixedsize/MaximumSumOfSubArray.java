package org.slidingwindow.fixedsize;

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

//same logic we can apply to calculate each window average we just need to calculate
//avg after each window like
//result.add(maxSum/k) this will calculate average for each window and remove max logic