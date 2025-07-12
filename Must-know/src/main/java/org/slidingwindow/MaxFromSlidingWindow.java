package org.slidingwindow;

import java.util.*;

public class MaxFromSlidingWindow {

    public static List<Integer> maxFromSlidingWindow(int[] arr, int k) {
        if (arr == null || k <= 0) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();  // will store indices

        for (int i = 0; i < arr.length; i++) {
            // 1. Remove indices of elements not in the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();  // remove from front
            }

            // 2. Remove elements smaller than the current from the back
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();  // remove from back
            }

            // 3. Add current index to the back
            deque.offerLast(i);

            // 4. Add the front element to result if window is valid
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);  // max in current window
            }
        }

        return result;
    }

}
