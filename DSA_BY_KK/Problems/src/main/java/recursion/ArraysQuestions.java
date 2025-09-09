package recursion;

import java.util.ArrayList;
import java.util.List;

public class ArraysQuestions {

    public static void main(String[] args) {

        System.out.println("Array is sorted or not [1,2,3,4,566,1] "+
                checkArrayIsSortedInAsc(new int[] {1,2,3,4,566,1},0));

        System.out.println("Linear Search [1,43,21,4,15,1,2] and target 4 present at index: "+
                linearSearch(new int[]{1,43,21,4,15,1,2},4, 0));

        System.out.println("Linear Search with arraylist [1,4,21,4,15,1,2] and target 4 present at index: " +
                linearSearchWithArrayList(new int[]{1, 4, 21, 4,15,1,2},4, 0,new ArrayList<>()));

        System.out.println("Linear Search arraylist(create inside body) without passing arraylist [1,4,21,4,15,1,2] and target 4 present at index: " +
                linearSearchWithOutPassingArrayList(new int[]{1, 4, 21, 4,15,1,2},4, 0));
    }

    //problem with this approach is for every call it create arraylist object, not recorded to use
    //just for knowledge
    static List<Integer> linearSearchWithOutPassingArrayList(int[] arr, int target, int index){

        List<Integer> list = new ArrayList<>();

        if(index == arr.length){
            return list;
        }

        if (arr[index] == target){
            list.add(index);
        }

        List<Integer> belowCallIndexes = linearSearchWithOutPassingArrayList(arr,target,index+1);

        //it will all called recursion call indexes if anything found
        //this will be followed for all calls and at the end its returned to actual where its called.
        list.addAll(belowCallIndexes);

        return list;
    }

    //we can same apply to find last index
    static List<Integer> linearSearchWithArrayList(int[] arr, int target, int index, List<Integer> list){

        if(index == arr.length){
            return list;
        }

        if (arr[index] == target){
            list.add(index);
        }

        return linearSearchWithArrayList(arr,target,index+1,list);
    }

    //we can same apply to find last index
    static int linearSearch(int[] arr, int target, int index){

        if(index == arr.length){
            return -1;
        }

        if (arr[index] == target){
            return index;
        }

        return linearSearch(arr,target,index+1);
    }

    static boolean checkArrayIsSortedInAsc(int[] arr, int index){

        if (index == arr.length-1){
            return true;
        }

        return arr[index]<=arr[index+1] && checkArrayIsSortedInAsc(arr,index+1);
    }
}
