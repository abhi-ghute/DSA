package sort;

import java.util.Arrays;

//it will sort left side of array with each iteration
//insert the jth/current element in right position
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 7, 5, 3, 5, 1, 44, 12};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void insertionSort(int[] arr) {

        //it will start from first element to last-1 element
        //as it will go till last element using j=i+1
        for (int i = 0; i < arr.length - 1; i++) {

            //it will always go till j>0 as for each pass we are doing j-1 to compare it with jth element
            for (int j = i + 1; j > 0; j--) {

                //swap if current element is less than previous element
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    //if not swapped means left array is sorted
                    break;
                }
                //so we have inserted the jth element to correct position
                //after each iteration we will get left array sorted till i+1/j
            }
        }
    }
}
