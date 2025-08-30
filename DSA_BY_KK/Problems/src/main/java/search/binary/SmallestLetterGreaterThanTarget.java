package search.binary;

//https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/

public class SmallestLetterGreaterThanTarget {

    public static void main(String[] args) {

        char[] letters = {'c','f','j'};
        char target = 'c';

        System.out.println("Next smallest letter greater than "
                +target+" "+nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;
            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        //returning mod of start because at the end if element not found start will be array length
        //if element is in between array or in array then next element will be start only which is next element for given element
        //mod will give the same start if it is not n
        return letters[start % letters.length];
    }

}
