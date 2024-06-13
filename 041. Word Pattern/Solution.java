class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] sChars = pattern.toCharArray();
        String[] tChars = s.split("\\s+");

        System.out.println(Arrays.toString(tChars));

        if (sChars.length == 0 || tChars.length != sChars.length) return false;

        Map<Character, String> charSCountMap = new HashMap<>();
        Map<String, Character> charTCountMap = new HashMap<>();

        for (int i = 0; i < sChars.length; i++) {
            char c = sChars[i];
            String d = tChars[i];

            // Check if current pattern character c already exists in map
            if (charSCountMap.containsKey(c)) {
                // If it exists, check if it maps to the correct word d
                if (!charSCountMap.get(c).equals(d)) {
                    return false; // If not, return false
                }
            } else {
                // If current pattern character c does not exist in map,
                // but the corresponding word d does exist and maps to another pattern character,
                // return false
                if (charTCountMap.containsKey(d) && charTCountMap.get(d) != c) {
                    return false;
                }
                // Otherwise, put c -> d and d -> c in the maps
                charSCountMap.put(c, d);
                charTCountMap.put(d, c);
            }
        }

        return true; // If all checks pass, return true
    }
}