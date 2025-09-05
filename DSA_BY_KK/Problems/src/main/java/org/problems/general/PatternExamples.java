package org.problems.general;

//https://github.com/abhi-ghute/DSA-Bootcamp-Java-KK/blob/main/assignments/09-patterns.md
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

        System.out.println("Pattern30:");
        pattern30(6);

        System.out.println("Pattern17:");
        pattern17(6);

        System.out.println("Pattern31:");
        pattern31(6);
    }

    static void pattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n) {
        for (int i = 1; i <= 2 * n - 1; i++) {
            int c = i <= n ? i : n * 2 - i;
            for (int j = 1; j <= c; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern28(int n) {
        for (int i = 1; i <= 2 * n - 1; i++) {

            int spaces = i <= n ? n - i : i - n;
            for (int s = 1; s <= spaces; s++) {
                System.out.print(" ");
            }

            int c = i <= n ? i : n * 2 - i;
            for (int j = 1; j <= c; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern30(int n) {
        for (int i = 1; i <= n; i++) {

            for (int s = 1; s <= n - i; s++) {
                System.out.print("  ");
            }

            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }

            for (int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void pattern17(int n) {
        for (int i = 1; i <= n * 2; i++) {

            int c = i > n ? 2 * n - i : i;
            for (int s = 0; s < n - c; s++) {
                System.out.print("  ");
            }

            for (int j = c; j >= 1; j--) {
                System.out.print(j + " ");
            }

            for (int j = 2; j <= c; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void pattern31(int n) {
        // The size of the square pattern will be (2n - 1)
        // For n = 4, size = 7 (i.e., 7x7 pattern)
        int size = 2 * n - 1;

        // Loop over each row
        for (int i = 0; i < size; i++) {

            // Loop over each column in the current row
            for (int j = 0; j < size; j++) {

                // Find the minimum distance from the current cell (i, j)
                // to any of the 4 borders (top, bottom, left, right)
                int top = i;                    // Distance from top border
                int left = j;                   // Distance from left border
                int bottom = size - 1 - i;      // Distance from bottom border
                int right = size - 1 - j;       // Distance from right border

                // Get the minimum of the 4 distances above
                int minDistance = Math.min(Math.min(top, bottom), Math.min(left, right));

                // Subtract minDistance from n to get the correct value for the pattern
                // The closer the cell is to the edge, the larger the number (starting from n)
                int value = n - minDistance;

                // Print the value with a space
                System.out.print(value + " ");
            }

            // Move to the next line after each row
            System.out.println();
        }
    }
}
