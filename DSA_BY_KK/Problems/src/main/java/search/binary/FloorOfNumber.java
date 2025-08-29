package search.binary;

public class FloorOfNumber {

    public static void main(String[] args) {
        int[] arr = {12, 15, 62, 100, 144, 355, 356, 405, 406, 556};
        int target = 406;

        int ceilingIndex = floorOfNumber(arr, target);

        System.out.println(ceilingIndex + " index is floorNumber for " + target);

    }

    /**
     * This method finds the index of the largest number in the array
     * that is less than or equal to the target (i.e., the "flooring").
     */
    static int floorOfNumber(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        // If target is less than or equal the smallest element in the array,
        // there is no flooring, so return -1
        if (target <= arr[start])
            return -1;

        // Binary search loop as this is sorted array
        while (start <= end) {

            int mid = start + (end - start) / 2;

            // If target is mid then -1 as we need to get floor number
            if (arr[mid] == target) {
                return mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        //we return end because after start <= end this is false end is smaller
        //which is our flooring number as it is not found at mid
        return end;
    }
}
