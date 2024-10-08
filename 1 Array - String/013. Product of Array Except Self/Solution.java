class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n]; // array to store the result 

        // Step 1: Calculate the product of all elements 0n the left of each element
        // the first element has no elements on the left so initialize answer [0] to 1
        answer[0] = 1;
        for (int i = 1; i < n ; i++){
            // 
            answer[i] = answer[i - 1]  * nums[i - 1];
        }

        // Step 2: Multiply the product of all element on the right of each element
        // Initialize a variable to track the product of all element on the right
        int rightProduct = 1;
        for (int i = n -1; i >= 0; i--){
            // Multiply the current value in answer[i] (product all of the left element) with
            //rightProduct (product all of the right element) 
            answer[i] *= rightProduct;
            //update rightProduct to include nums[i] for the next left element
            rightProduct *= nums[i];
        }

        return answer;

    }
}