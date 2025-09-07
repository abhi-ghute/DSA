package org.problems.general;

//https://leetcode.com/problems/reverse-only-letters/
public class ReverseOnlyLetters {

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        //o/p: "j-Ih-gfE-dCba"
    }

    static String reverseOnlyLetters(String s) {

        char[] arr = s.toCharArray();
        int i = 0, j = s.length() - 1;

        while (i < j) {
            // Skip non-letter characters
            if (!Character.isLetter(arr[i])) {
                i++;
            } else if (!Character.isLetter(arr[j])) {
                j--;
            } else {
                // Swap letters
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return new String(arr);
    }
}
