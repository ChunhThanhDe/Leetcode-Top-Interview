class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            String currMap = countCharacter(word);
            // if (!map.containsKey(currMap)) {
            //     map.put(currMap, new ArrayList<>());
            // }
            // map.get(currMap).add(word);
            
            // Use the new method "computeIfAbsent" and Lambda Expression in JDK1.8
            map.computeIfAbsent(currMap, x -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public String countCharacter(String str) {
        int[] map = new int[26];
        for (char c : str.toCharArray()) {
            map[c - 'a']++;
        }
        return Arrays.toString(map);
    }
}