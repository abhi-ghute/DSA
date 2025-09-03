package sort.cyclic;

//find duplicate from 1 to N
//Floyd's Tortoise and Hare (Cycle Detection) is best approach
//amazon/microsoft
//https://leetcode.com/problems/find-the-duplicate-number/
//nums from 1 to n
public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,5,6,7,2,7,4,3};

        System.out.println(findDuplicateUsingCyclicSort(nums));
    }

    static int findDuplicateUsingCyclicSort(int[] nums){
        //cyclic sort
        int i = 0;
        while(i<nums.length){
            int correctIndex = nums[i]-1;

            if(nums[correctIndex] != nums[i]){
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            }else {
                //if i and correct index are not same then
                //it means element is same and not at correct index
                if(i != correctIndex){
                    return nums[i];
                }
                i++;
            }

        }

        return -1;
    }
}
