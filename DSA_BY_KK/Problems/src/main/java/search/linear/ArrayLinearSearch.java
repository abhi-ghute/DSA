package search.linear;

public class ArrayLinearSearch {

    public static void main(String[] args) {

        int[] arr = {21, 90, 45, 234, 5, 23, 90, 123, -55};
        int target = 23;

        int index = linearSearch(arr, target);
        System.out.println(target + " found at index " + index);
    }

    // we can optimize this using two pointer approach
    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
}
