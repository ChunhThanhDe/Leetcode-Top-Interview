public class Solution {
    public List<String> summaryRanges(int[] nums) {
     List<String> rst = new ArrayList<>();
     if (nums == null || nums.length == 0) {
     	return rst;
     }   
     List<Integer> list = new ArrayList<>();
     for (int i = 0; i < nums.length; i++) {
     	list.add(nums[i]);
     	if (i + 1 == nums.length || nums[i] + 1 != nums[i + 1]) {
     		if (list.size() == 1) {
     			rst.add(list.get(0) + "");
     		} else {
     			rst.add(list.get(0) + "->" + list.get(list.size() - 1));
     		}
     		list = new ArrayList<Integer>();
     	}
     }
     return rst;
    }
}