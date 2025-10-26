package org.problems.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
// Given a string, find the length of the longest substring in it with no more than K distinct characters.
// You can assume that K is less than or equal to the length of the given string.
public class LongestSubstringWithKDistinctChars {

    public static void main(String[] args) {
        String str = "cbbebi";
        int k = 3;

        double result1 = longestSubstringWithKdistinct_BruteForce(str, k);
        double result2 = longestSubstringWithKdistinct(str, k);

        System.out.println("Using BruteForce: " + result1);
        System.out.println("Using Sliding window: " + result2);
    }

    // Sliding Window approach (O(n))
    private static double longestSubstringWithKdistinct(String str, int k) {
        if (k == 0) return 0;

        int left = 0, maxLen = 0;
        Map<Character, Integer> charCount = new HashMap<>();

        // Expand the window with 'right' and shrink with 'left' when distinct chars > k
        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);

            while (charCount.size() > k) {
                char leftChar = str.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Brute Force approach (O(n^3))
    private static double longestSubstringWithKdistinct_BruteForce(String str, int k) {
        int n = str.length();
        int maxLen = 0;

        // Check every possible substring
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String subString = str.substring(i, j);
                Set<Character> set = new HashSet<>();

                for (char c : subString.toCharArray()) {
                    set.add(c);
                }

                if (set.size() <= k) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }

        return maxLen;
    }
}
