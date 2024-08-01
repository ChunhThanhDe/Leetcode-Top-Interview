public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] c_arr = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (Character c : c_arr) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty() ? true : false;
    }
}