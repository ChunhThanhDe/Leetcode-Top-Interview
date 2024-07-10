class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap();
        
        /* 2, 7, 11, 15  ==  target=9
         * 0  1   2   3  => 4
         *  
         *    --HasMap--
         *  key   value(index)
         *   2  ->  0
         *   7  ->  1
         *
        */
        for(int i=0; i<nums.length; i++) {
           int expectedKey = target - nums[i];
           if(map.containsKey(expectedKey)) {
               return new int[]{map.get(expectedKey), i};
           }
           map.put(nums[i], i);
        }
             
        throw new IllegalArgumentException("No Solution");
    }
}