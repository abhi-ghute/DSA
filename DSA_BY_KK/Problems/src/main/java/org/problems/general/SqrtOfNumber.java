package org.problems.general;

public class SqrtOfNumber {

    public static void main(String[] args) {

        System.out.println(binarySearchSqrt(40,3));
        System.out.println(newtonRaphsonSqrt(36,3));
    }

    //n->number, p -> precision
    //time complexity : O(logn)
    //as we will start from 2,3,4,5,6... as this is sorted then we can binary sort instead checking each number
    static double binarySearchSqrt(int n, int p){
        double root = 0;
        int start = 0;
        int end = n/2; //we can start by n/2 as sqrt will be always below or equal n/2

        while (start<=end){

            int mid = start + (end-start)/2;
            long square = (long) mid * mid; // to avoid integer overflow

            //perfect sqrt found return
            if (square == n) {
                return mid;
            }

            //if mid*mid is greater than number then sqrt lies before mid
            if(square > n){
                end = mid -1; // discard right half
            }else {
                //if mid*mid is less than then our sqrt lies next to mid
                start = mid+1; // discard left half
                root = mid; // we will consider mid as our root
            }
        }

        //this is precision logic we will start adding from 0.1 for p iterations
        double incr = 0.1;
        for(int i=0;i<p;i++){

            //this loop will keep adding incr to the root until root*root < n
            while(root*root < n){
                root +=incr;
            }

            //as while condition violated that why we need to subtract incr as root * root is ahead our number
            root -=incr;
            //for next precision we need 0.001 so /10 for each next precision
            incr /= 10;
        }

        return root;
    }

    public static double newtonRaphsonSqrt (double n, int precision) {
        double x = n;
        double root;
        double error = 0.5;//Math.pow(10, -precision); // e.g., 1e-3 for 3 decimal places

        while (true) {
            root = 0.5 * (x + n / x); // Newton-Raphson formula 1/2(x+n/x)

            if (Math.abs(root - x) < error) { // it will break if the error is below that we mentioned
                break;
            }

            x = root;
        }

        // Round to required precision
        //return Math.round(root * Math.pow(10, precision)) / Math.pow(10, precision);
        return root;
    }
}
