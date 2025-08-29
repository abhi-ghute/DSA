package search.binary;

public class CeilingOfNumber {

    public static void main(String[] args) {
        int[] arr = {12, 15, 62, 100, 144, 355, 356, 405, 406, 556};
        int target = 556;

        int ceilingIndex = ceilingOfNumber(arr, target);

        System.out.println(ceilingIndex + " index is ceilingNumber for " + target);

    }

    /**
     * This method finds the index of the smallest number in the array
     * that is greater than or equal to the target (i.e., the "ceiling").
     */
    static int ceilingOfNumber(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        // If target is greater than or equal the largest element in the array,
        // there is no ceiling, so return -1
        if(target>=arr[end])
            return -1;

        // Binary search loop as this is sorted array
        while (start <= end) {

            int mid = start + (end - start) / 2;

            // If target is mid then +1 as we need to get ceiling number
            if (arr[mid] == target) {
                return mid+1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        //we return start because after start <= end this is false start is greater
        //which is our ceiling number as it is not found at mid
        return start;
    }
}
