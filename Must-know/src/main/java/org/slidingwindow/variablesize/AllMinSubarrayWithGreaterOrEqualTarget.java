package org.slidingwindow.variablesize;

import java.util.ArrayList;
import java.util.List;

public class AllMinSubarrayWithGreaterOrEqualTarget {

    public static List<int[]> allMinSubarrays(int target, int[] arr){
        int sum = 0, start = 0 , minLength = 0;

        List<int[]> candidates = new ArrayList<>();

        for(int end=0;end<arr.length;end++){

            sum +=arr[end];

            while(sum>=target){

            }
        }
        return candidates;
    }
}
