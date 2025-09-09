package recursion;

public class RotatedBinarySearch {

    public static void main(String[] args) {

        int[] arr = new int[]{7,6,5,1,2,3,4};
        System.out.println(
                rotatedBinarySearch(arr,3,0,arr.length-1));
    }

    //7,6,5,1,2,3,4
    static int rotatedBinarySearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[start] <= arr[mid]) {
            if (target >= arr[start] && target < arr[mid]) {
                return rotatedBinarySearch(arr, target, start, mid - 1);
            } else {
                return rotatedBinarySearch(arr, target, mid + 1, end);
            }
        } else if (target > arr[mid] && target <= arr[end]) {
            return rotatedBinarySearch(arr, target, mid + 1, end);
        } else {
            return rotatedBinarySearch(arr, target, start, mid - 1);
        }
    }
}
