package sort;

import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {
        int[] arr = {4,3,1,5,2,7,6,};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclicSort(int[] arr){

        int i = 0;
        while (i < arr.length){
            int correctIndex = arr[i] - 1;
            if(arr[i] != arr[correctIndex]){
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[i];
                arr[i] = temp;
            }else {
                i++;
            }
        }
    }
}
