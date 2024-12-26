/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-08-01 08:11:19
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// input: A String `s` containing brackets '(', ')', '{', '}', '[', and ']'
// output: boolean indicating if the string has valid bracket pairs

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // initialize a stack to store opening brackets
        Stack<Character> stack = new Stack<>();

        // Step 1: Iterate through each character in the String
        for (char c : s.toCharArray()){
            // Step 2: Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                // Step 3: Process closing brackets
                // if stack is empty and check if it matches the closing bracket

                if (stack.isEmpty()) return false;

                // Pop the top element and check if it matches the closing bracket
                char top = stack.pop();
                if ((c == ')' && top != '(')||
                    (c == '}' && top != '{')||
                    (c == ']' && top != '[')){
                    return  false; // Brackets do not match
                }
            }
        }

        // Step 4: Ensure no unmatched opening brackets remain
        return stack.isEmpty();
    }

    // testcase
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Simple valid parentheses
        String s1 = "()";
        System.out.println("Test case 1: " + solution.isValid(s1)); // Expected output: true

        // Test case 2: Mixed valid brackets
        String s2 = "()[]{}";
        System.out.println("Test case 2: " + solution.isValid(s2)); // Expected output: true

        // Test case 3: Invalid parentheses order
        String s3 = "(]";
        System.out.println("Test case 3: " + solution.isValid(s3)); // Expected output: false

    }
}