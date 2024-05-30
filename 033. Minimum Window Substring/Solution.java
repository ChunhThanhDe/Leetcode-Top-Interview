class Solution {
  public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
      
        int start=0, end=0, left=0, right=0, target=t.length();
        while (right < s.length()) {
            int count = map.getOrDefault(s.charAt(right) , 0);
            if (count > 0)  {
            	// System.out.println("Matched : "+ s.charAt(right)+" at index " + right);
            	target--;
            }
            map.put(s.charAt(right),count-1);
            right++;
            while (target == 0) {
            	// System.out.println("Map : " + map);
            	// System.out.println("Left : " + left);
                if (end == 0 || end - start > right - left) {
                    start = left; 
                    end = right;
                }
                int value = map.getOrDefault(s.charAt(left),0);
                if (value >= 0) target++;
                map.put(s.charAt(left),value + 1);
                left++;
            }
            
        }
        return s.substring(start, end);
    }
}