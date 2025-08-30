package search.binary;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class FindFirstAndLastPosition {

    public static void main(String[] args) {
        int[] nums =  {5,7,7,7,7,8,8,8,10};
        int target = 7;

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {

        int[] ans = {-1,-1};

        //we are passing true when we are searching for first index and for last it is false
        ans[0] = search(nums,target,true);

        //if not found in entire array then no need to check for last position
        if(ans[0] != -1){
            ans[1] = search(nums,target,false);
        }
        return ans;
    }

    private static int search(int[] nums, int target, boolean isfirstIndex){
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while(start <= end){

            int mid =  start + (end - start)/2;

            //here we are checking if it found that could be potential start or end index
            //but possibility to present in left and right, that's why we will check
            //left or right partition based on checking for or last index
            //until it not found
            if(nums[mid] == target){
                ans = mid;
                if(isfirstIndex){
                    end = mid -1;
                }else{
                    start = mid+1;
                }
            }else if(target<nums[mid]){
                end = mid - 1;
            }else {
                start = mid+1;
            }
        }
        return ans;
    }
}
