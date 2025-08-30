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
            return binarySearch(nums, target, 0, nums.length-1);
        }else if(nums[pivot] == target){
            return pivot;
        }else if(target<nums[0]){
            return binarySearch(nums, target, pivot+1, nums.length-1);
        }else{
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

    private static int peakElementIndex(int[] nums){

        int start = 0;
        int end = nums.length -1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(mid<end  && nums[mid] > nums[mid+1]){
                return mid;
            }else if(mid>start && nums[mid] < nums[mid-1]){
                return mid-1;
            }else if(nums[start]<=nums[mid]){
                start = mid+1;
            }else if(nums[start]>nums[mid]){
                end = mid-1;
            }
        }

        return -1;

    }
}
