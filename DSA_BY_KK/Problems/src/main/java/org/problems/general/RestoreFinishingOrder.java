package org.problems.general;

import java.lang.reflect.Array;
import java.util.Arrays;

//https://leetcode.com/problems/restore-finishing-order/
public class RestoreFinishingOrder {

    public static void main(String[] args) {

        int[] order = {3,1,2,5,4};
        int[] friends = {1,3,4};

        System.out.println(Arrays.toString(recoverOrder(order,friends)));
    }
    static int[] recoverOrder(int[] order, int[] friends) {
        int[] ans = new int[friends.length];
        int index = 0;

        for(int n : order){
            if(isPresentInFriend(friends,n)){
                ans[index++] = n;
            }
        }
        return ans;
    }

    static boolean isPresentInFriend(int[] friends, int target){
        int start = 0;
        int end = friends.length-1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(friends[mid] == target){
                return true;
            }

            if(friends[mid]<target){
                start = mid+1;
            } else{
                end = mid-1;
            }
        }

        return false;
    }
}
