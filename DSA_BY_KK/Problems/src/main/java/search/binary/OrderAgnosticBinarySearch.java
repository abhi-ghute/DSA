package search.binary;

//this used when array is sorted but we don't know the sorting order
public class OrderAgnosticBinarySearch {

    public static void main(String[] args) {

        int[] ascArr = {1,2,3,4,5,6,7,8};
        int ascTarget = 3;

        int ascIndex = orderAgnosticBinarySerach(ascArr, ascTarget);
        System.out.println(ascTarget +" from asc array found at index "+ascIndex);

        int[] descArr = {9,8,7,6,5,4,3,2,1};
        int descTarget = 1;

        int descIndex = orderAgnosticBinarySerach(descArr,descTarget);
        System.out.println(ascTarget +" from desc array found at index "+descIndex);
    }

    static int orderAgnosticBinarySerach(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {

            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (arr[mid] < target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }else {
                if (arr[mid] > target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }

        return -1;
    }
}
