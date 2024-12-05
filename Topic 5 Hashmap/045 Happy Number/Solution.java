// input: an integer
// output: boolean, true if n is happy number

import java.util.HashSet;
import java.util.Set;

public class Solution{
    public boolean isHappy(int n){

        // use set to track numbers that have been seen before
        Set<Integer> seen = new HashSet<>();

        // repeat until n equals 1 or a cycle is detected
        while (n != 1 && !seen.contains(n)){
            seen.add(n); // add the current number to set
            n = getNext(n); // get the next number
        }

        // return if n == 1 or cycle is detected
        return n == 1;
    }

    // function to calculate the next number in the sequence
    private int getNext(int n){
        int totalSum = 0;

        // loop to each element of number n
        while (n > 0){
            int a = n%10; // get the last element
            totalSum += a * a;
            n /= 10; // remove the last element
        }

        // return the sum of squares element of n
        return totalSum;
    }
}