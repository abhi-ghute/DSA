package org.slidingwindow.variablesize;

public class Main {
    public static void main(String[] args) {
        System.out.println("Maximum sum of subarray");

        String s = "abacdbb";
        String result = LengthOfLongestSubstring.longestSubstringWithoutRepeating(s);
        System.out.println("Longest substring without repeating characters: " + result);
    }
}