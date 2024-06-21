class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        if (sChars.length != tChars.length) return false;

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (charCountMap.containsKey(c) && charCountMap.get(c) > 0) {
                charCountMap.put(c, charCountMap.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}