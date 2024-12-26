/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-12-23 10:34:08
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// input: String s, a valid expression
// output: int, calculator th result of the evaluation
// note: s consists of digits, '+', '-', '(', ')', and spaces ' '

import java.util.*;

public class Solution {
    public int calculate(String s){
        Stack<Integer> stack = new Stack<>(); // to handle '(' ')'
        int result = 0;
        int sign = 1; // (+ or -)
        int num = 0; // num now


        for (char c : s.toCharArray()){
            if (Character.isDigit(c)){
                num = num * 10 + (c - '0'); // build number by digit
            } else if (c == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-'){
                result += sign * num;
                num = 0;
                sign = -1; // Set the sign to - for the next numbe
            } else if (c == '('){
                stack.push(result); // save current
                stack.push(sign);
                result = 0; // Reset the result for the new ()
                sign = 1;
            } else if ( c ==')'){
                result += sign * num;
                num = 0; // Reset the number
                result *= stack.pop();  // Apply the sign from the last '('
                result += stack.pop();  // Add the previous result from before '('
            }
        }

        if (num != 0) {
            result += sign * num;
        }

        return  result;
    }
}