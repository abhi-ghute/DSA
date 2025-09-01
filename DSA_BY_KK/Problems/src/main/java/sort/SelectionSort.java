package sort;

import java.util.Arrays;

//instead of doing swap in each iteration like bubble sort
//it will just swap one time after finding correct min/max to start/end position for each pass
//this will reduce unnecessary swaps
public class SelectionSort {

    public static void main(String[] args) {

        int[] arr1 = {7,6,3,4,6,24,5};
        selectionSortWithMinApproach(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {17,56,35,14,33,42,11};
        selectionSortWithMaxApproach(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    //[(4, A), (3, B), (4, C), (2, D)]
    //its not stable as 4,A will go at end after first sort
    //even though we skip swapping if number is at correct index
    static void selectionSortWithMinApproach(int[] arr) {

        int n = arr.length;
        if (n == 0)
            return;

        //it will start from firs index and consider each i as min for each pass
        //after each iteration we will get ith in correct position, which is min from that iteration
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            //this will start i+1 as it will compare i with all next indexes
            // Find the index of the min element
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }

            // swap only if minIndex is not same with i
            if(minIndex != i){
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    //[(6, A), (5, B), (2, C), (3, D)]
    //this approach also not stable
    static void selectionSortWithMaxApproach(int[] arr) {

        int n = arr.length;
        if (n == 0)
            return;

        //it will start from last index and consider each i as max for each pass
        //after each iteration we will get ith in correct position, which is max from that iteration
        for (int i = n-1; i > 0; i--) {
            int maxIndex = i;

            //this will start 0 as it will compare till i-1
            // Find the index of the maximum element
            for(int j=0;j<i;j++){
                if(arr[j]>arr[maxIndex]){
                    maxIndex = j;
                }
            }

            // swap only if maxIndex is not same with i
            if(maxIndex != i){
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
