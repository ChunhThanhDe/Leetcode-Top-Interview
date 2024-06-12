class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Map<Character, Character> charSCountMap = new HashMap<>();
        Map<Character, Character> charTCountMap = new HashMap<>();

        if (sChars.length == 0 || tChars.length != sChars.length) return false;

        for (int i = 0; i < sChars.length; i++) {
            char c = sChars[i];
            char d = tChars[i];
            if ((!charSCountMap.containsKey(c) && !charTCountMap.containsKey(d)) ||
                (charSCountMap.containsKey(c) && charSCountMap.get(c) == d && 
                 charTCountMap.containsKey(d) && charTCountMap.get(d) == c)) {
                charSCountMap.put(c, d);
                charTCountMap.put(d, c);
            } else {
                return false;
            }
        }
        return true;
    }
}