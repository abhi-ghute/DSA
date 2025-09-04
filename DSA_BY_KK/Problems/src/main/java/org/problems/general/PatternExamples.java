package org.problems.general;

public class PatternExamples {

    public static void main(String[] args) {
        System.out.println("Pattern1:");
        pattern1(6);

        System.out.println("Pattern2:");
        pattern2(6);

        System.out.println("Pattern3:");
        pattern3(6);

        System.out.println("Pattern5:");
        pattern5(6);

        System.out.println("Pattern28:");
        pattern28(6);
    }

    static void pattern1(int n){
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n){
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n){
        for (int i = 1; i <=n ; i++) {
            for (int j = i; j<=n ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n){
        for (int i = 1; i <= 2 * n-1 ; i++) {
            int c = i <= n ? i : n*2-i;
            for (int j = 1; j<=c; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern28(int n){
        int sp =1;
        for (int i = 1; i <= 2 * n-1 ; i++) {

            int spaces = i<=n ? n/2 - i + 3 : sp++;
            for(int s=1;s<=spaces;s++){
                System.out.print(" ");
            }

            int c = i <= n ? i : n*2-i;
            for (int j = 1; j<=c; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
