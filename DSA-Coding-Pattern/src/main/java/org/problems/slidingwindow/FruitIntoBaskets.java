package org.problems.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//https://leetcode.com/problems/fruit-into-baskets/
//Given an array of characters where each character represents a fruit tree, you are given two baskets, and your goal is to put the maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
//You can start with any tree, but you cant skip a tree once you have started. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
//Write a function to return the maximum number of fruits in both baskets.
public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};

        int result1 = totalFruit_BruteForce(fruits);
        int result2 = totalFruit(fruits);

        System.out.println("Using BruteForce: " + result1);
        System.out.println("Using Sliding window: " + result2);
    }

    private static int totalFruit(int[] fruits) {
        int maxCount = 0, start = 0;
        int n = fruits.length;
        HashMap<Integer, Integer> basket = new HashMap<>();

        for (int end = 0; end < n; end++) {
            basket.put(fruits[end], basket.getOrDefault(fruits[end],0)+1);

            while (basket.size()>2){
                basket.put(fruits[start],basket.get(fruits[start])-1);
                if (basket.get(fruits[start])==0){
                    basket.remove(fruits[start]);
                }
                start++;
            }
            maxCount = Math.max(maxCount, end - start + 1);
        }

        return maxCount;
    }

    private static int totalFruit_BruteForce(int[] fruits) {
        int maxCount = 0;
        int n = fruits.length;

        for (int i=0;i<n;i++){
            HashSet<Integer> basket = new HashSet<>();
            int count =0;
            for (int j = i; j < n ; j++) {
                basket.add(fruits[j]);
                if(basket.size()>2){
                    break;
                }
                count++;
            }
            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }
}
