/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-08-05 08:25:30
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// input: a Unix-style file system (String path)
// output: the  simplified canonical path.

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path){
        //Stack to hold the directories as we process the path.
        Stack<String> stack = new Stack<>();

        //Split the input path
        String[] components = path.split("/");

        // Step 1: Process each components in th split path
        for (String c : components){
            // ignore empty components and "." (current directory)'
            if (c.isEmpty() || c.equals(".")) {
                continue;
            } else if (c.equals("..")){
                if (!stack.isEmpty()) {
                    stack.pop(); // Move up one level by popping from stack.
                }
            } else {
                // Otherwise, push the valid directory name onto the stack
                stack.push(c);
            }
        }

        // Step 2: Build the simplified canonical path
        StringBuilder result = new StringBuilder();

        // Iterate through the stack and create path
        for (String s : stack){
            result.append("/").append(s);
        }

        // Return the result, or "/" if stack is empty (root patch)
        return result.length() > 0 ? result.toString() : "/";
    }

    // Testcase
    public static void main(String[] args){
        Solution solution = new Solution();

        String path1 = "/home/";
        String path2 = "/home//foo/";
        String path3 = "/home/user/Documents/../Pictures";
        String path4 = "/../";
        String path5 = "/.../a/../b/c/../d/./";

        System.out.println("Test: " + solution.simplifyPath(path1));
        System.out.println("Test: " + solution.simplifyPath(path2));
        System.out.println("Test: " + solution.simplifyPath(path3));
        System.out.println("Test: " + solution.simplifyPath(path4));
        System.out.println("Test: " + solution.simplifyPath(path5));
    }

}