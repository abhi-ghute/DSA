package org.slidingwindow;

import java.util.*;

public class FirstNegativeInWindow {

    public static List<Integer> firstNegativeInWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            // Add index of negative numbers
            if (arr[end] < 0) {
                queue.addLast(end);
            }

            // When window size reached
            if (end - start + 1 == k) {
                // If queue not empty, front of queue is first negative number's index
                if (!queue.isEmpty()) {
                    result.add(arr[queue.peekFirst()]);
                } else {
                    result.add(0);
                }

                // Remove indices that are out of the current window
                if (!queue.isEmpty() && queue.peekFirst() == start) {
                    queue.pollFirst();
                }

                // Slide window forward
                start++;
            }
        }
        return result;
    }
}


/**
 ✅ Algorithm Steps:

 1.Initialize a queue Deque<Integer> to store indices of negative numbers.
 2.Use two pointers: start and end to manage the window.
 3.slide the window from 0 to n-1.
 4.For every end:
    a.If arr[end] is negative, add it to the queue.
    b.If window size end - start + 1 < k, move end forward.
    c.If window size equals k:
        1.If the queue is not empty, add arr[queue.peek()] to the result.
        2.If the queue is empty, add 0.
        3.If arr[start] equals the front of the queue, remove it.
        4.Slide the window: start++.
 */