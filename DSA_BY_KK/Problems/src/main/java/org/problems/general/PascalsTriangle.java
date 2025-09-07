package org.problems.general;

//What is Pascal’s Triangle?
//Pascal’s Triangle is a triangle where:
//Each number is the sum of the two numbers directly above it.
//The first row is 1, and the triangle grows downward.

import java.util.ArrayList;
import java.util.List;

/*
Row 0:             1
Row 1:           1   1
Row 2:         1   2   1
Row 3:       1   3   3   1
Row 4:     1   4   6   4   1
Row 5:   1   5  10  10   5   1

 */
public class PascalsTriangle {

    public static void main(String[] args) {
        getPascalRow(5);
        getSumofPscalRow(2);
    }

    private static void getSumofPscalRow(int n) {
        //if we consider row from 1 then n-1
        //we can use math.power function as well
        System.out.println(4<<n);
    }

    private static void getPascalRow(int n) {
        List<Integer> row = new ArrayList<>();
        int value = 1;
        row.add(value); // C(n, 0) is always 1
        for (int k = 1; k <= n; k++) {
            value = value * (n - k + 1) / k; // C(n, k) = C(n, k-1) * (n-k+1) / k
            row.add(value);
        }

        System.out.println(row);
    }
}
