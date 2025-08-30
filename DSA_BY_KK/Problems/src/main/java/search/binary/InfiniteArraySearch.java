package search.binary;

import java.util.List;

//https://www.geeksforgeeks.org/dsa/find-position-element-sorted-array-infinite-numbers/
//if we don't know the size of array or without getting size of array
public class InfiniteArraySearch {

    public static void main(String[] args) {

        List<Integer> list = List.of(3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170);
        int target = 170;

        System.out.println(searchInInfiniteArray(list,target));
    }

    //this method gives us a start and end pointer, we are checking with end
    //and if its not present we are taking double elements for next than current
    //exactly opposite to binary search
    static int searchInInfiniteArray(List<Integer> list, int target){

        int start = 0;
        int end = 1;

        //this solution might gives AIOBE if it exceeds the length
//        while(target > list.get(end)){
//            int tempStart = end+1;
//            end = end + (end - start+1)*2;
//            start = tempStart;
//        }

        // Find high to do binary search
        while (end < list.size() && list.get(end) < target) {
            // Store previous high
            start = end;
            // Double high index
            end = 2 * end;
        }

        // Clamp high if it goes out of array bounds
        if (end >= list.size())
            end = list.size() - 1;

        // At this point, we have updated low and high
        // indices, thus use binary search between them
        return binarySearch(list, target, start, end);
    }

    static int binarySearch(List<Integer> list, int target, int start, int end){

        while(start <= end){

            int mid =  start + (end - start)/2;

            if(list.get(mid) == target){
                return mid;
            }else if(list.get(mid)<target){
                start = mid+1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
