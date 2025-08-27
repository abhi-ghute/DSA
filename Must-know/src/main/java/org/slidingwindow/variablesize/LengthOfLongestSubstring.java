package org.slidingwindow.variablesize;

import java.util.HashMap;

public class LengthOfLongestSubstring {

    public static String longestSubstringWithoutRepeating(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;   // Start pointer of current window
        int maxStart = 0; // Start index of the longest substring found

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            if (map.containsKey(currentChar)) {
                // If the current char was seen before, move start pointer
                // to the right of the previous index of this char if it's ahead of current start
                start = Math.max(map.get(currentChar) + 1, start);
            }

            map.put(currentChar, end); // Update or add current character index

            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                maxStart = start;
            }
        }

        return s.substring(maxStart, maxStart + maxLength);
    }
}
