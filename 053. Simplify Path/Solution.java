public class Solution {
    public String simplifyPath(String path) {
        // Split the input path by "/"
        String[] arr = path.split("/");
        // Use a stack to store the components of the path
        Stack<String> st = new Stack<>();

        // Iterate through each component of the array
        for (String str : arr) {
            // If the component is "..", pop the stack if it is not empty
            if (str.equals("..")) {
                if (!st.isEmpty()) st.pop();
            // If the component is not "." and not empty, push it onto the stack
            } else if (!str.equals(".") && !str.isEmpty()) {
                st.push(str);
            }
        }

        // Initialize the result string
        String res = "";
        // If the stack is empty, return "/"
        if (st.isEmpty()) return "/";

        // Construct the valid path from the components in the stack
        while (!st.isEmpty()) {
            res = "/" + st.pop() + res;
        }

        return res;
    }
}
