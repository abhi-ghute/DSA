package org.problems.general;

import java.util.ArrayList;
import java.util.List;

public class FactorsOfNumber {

    public static void main(String[] args) {
        factors(20);
        factors2(20);
        factors3(20);
    }

    static void factors(int n){
        //as here after some point factors are repeating itself like
        //1*20->20*1, 2*10->10*2, 4*5->5*4
        //we can optimize it
        for(int i=1;i<=n;i++){
            if(n%i ==0){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    static void factors2(int n){
        //if we look at result i are printing in asc order and i/2 in desc order
        //if we want it in asc order then we can store n/i in other list and print at last
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i ==0){
                //to skip same number like 6*6
                if(n/i == i){
                    System.out.print(i+" ");
                }else {
                    System.out.print(i+" "+n/i+" ");
                }
            }
        }
        System.out.println();
    }

    static void factors3(int n){

        List<Integer> list = new ArrayList<>();

        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i ==0){
                if(n/i == i){
                    System.out.print(i+" ");
                }else {
                    System.out.print(i+" ");
                    list.add(n/i);
                }
            }
        }

        for (int i = list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+" ");
        }
    }


}
