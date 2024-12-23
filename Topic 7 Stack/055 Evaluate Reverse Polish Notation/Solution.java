// input: String[] tokens number and Valid operators
// output: int, result of RPN math calculations
import java.util.*;

public class Solution{
    public int evalRPN (String[] tokens){

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens){
            if (isValidOperators(token)){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(mathOperation(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isValidOperators(String token){
        return token.equals("*") || token.equals("+") || token.equals("-") || token.equals("/");
    }

    private int mathOperation(int a, int b, String token){
        switch (token){
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("not valid Operation");
        }
    }
}