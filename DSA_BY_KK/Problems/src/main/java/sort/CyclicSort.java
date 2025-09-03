package sort;

import java.util.Arrays;

//Cyclic Sort is a linear-time, in-place sorting algorithm that places each number
//at its correct index by repeatedly swapping elements until the current number is
// at its correct position.
// This need a range of consecutive numbers and with starting number
public class CyclicSort {

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 5, 2, 7, 6,};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclicSort(int[] arr) {

        int i = 0;
        while (i < arr.length) {
            //instead of arr[i]-1 we can use nums[i] - start number as well
            //which we can take as input/min of array, which will take us to 0 index
            int correctIndex = arr[i] - 1; //nums[i] - start if if random range of numbers provided
            if (arr[i] != arr[correctIndex]) {
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[i];
                arr[i] = temp;
            } else {
                i++;
            }
        }
    }
}
