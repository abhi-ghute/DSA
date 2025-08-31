package search.binary;

public class RotatedSortedAWithoutDulpicate {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {

        int pivot = peakElementIndex(nums);

        if(pivot == -1){
            //if pivot is negative search in whole array, ex: all are same numbers in array
            return binarySearch(nums, target, 0, nums.length-1);
        }else if(nums[pivot] == target){
            return pivot;
        }else if(target<nums[0]){
            //as array is rotated if 0th element is greater than target then it should present in right part
            //as all the elements before pivot are greater to start
            return binarySearch(nums, target, pivot+1, nums.length-1);
        }else{
            //otherwise search after pivot
            return binarySearch(nums, target, 0, pivot-1);
        }
    }

    private static int binarySearch(int[] nums, int target, int start, int end){

        while(start<=end){
            int mid = start + (end-start)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }

    //this will work on only if array not contains duplicates.
    private static int peakElementIndex(int[] nums){

        int start = 0;
        int end = nums.length -1;

        while(start <= end){
            int mid = start + (end-start)/2;
            //4 cases
            //if mid/mid-1 is greater then its peak because all the elements after or before peak are less
            if(mid<end  && nums[mid] > nums[mid+1]){
                return mid;
            }else if(mid>start && nums[mid] < nums[mid-1]){
                return mid-1;
            }else if(nums[start]<=nums[mid]){
                //if start and mid is equal then mid is not peak as we already checked, i.e present after mid
                start = mid+1;
            }else if(nums[start]>nums[mid]){
                //if end and mid is equal then mid is not peak as we already checked, i.e present before mid
                end = mid-1;
            }
        }
        return -1;
    }
}
