class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        for (char c : ransomNote.toCharArray()) {
            if (charCountMap.containsKey(c) && charCountMap.get(c) > 0) {
                charCountMap.put(c, charCountMap.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;

        
        
    }
}