/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-08-06 09:53:54
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

import java.util.Stack;

class MinStack {

    // main stack to store all elements
    private Stack<Integer> stack;
    // auxiliary stack to store the minumum element at each state
    private Stack<Integer> minStack;

    // Constructor: initlizes the stack and minStack
    public MinStack(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element val onto the stack
    public void push (int val){
        stack.push(val); // add value to main stack

        // Check current minStack and val
        if (minStack.isEmpty() || val < minStack.peek()){
            minStack.push(val);
        } else {
            minStack.push(minStack.peek()); // Repeat the current minimum
        }
    }

    // Remove the top element of the stack
    public void pop (){
        stack.pop(); // Remove top from the main stack
        minStack.pop();  // Remove top from the minStack
    }

    // Retrieve the top element of the stack.
    public int top(){
        return stack.peek(); // Return the top of the main stack
    }

    // Retrieve the minimum element in the stack.
    public int getMin(){
        return minStack.peek(); // Return the top of the minStack
    }

    public static void main(String[] args) {
        // Create a new MinStack object
        MinStack minStack = new MinStack();

        // Test case 1: Push elements and check minimum
        System.out.println("Test case 1:");
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("getMin(): " + minStack.getMin()); // Expected: -3
        minStack.pop();
        System.out.println("top(): " + minStack.top());       // Expected: 0
        System.out.println("getMin(): " + minStack.getMin()); // Expected: -2

        // Test case 2: Push additional elements
        System.out.println("\nTest case 2:");
        minStack.push(5);
        minStack.push(-1);
        System.out.println("getMin(): " + minStack.getMin()); // Expected: -2
        minStack.pop();
        System.out.println("getMin(): " + minStack.getMin()); // Expected: -2
    }
}