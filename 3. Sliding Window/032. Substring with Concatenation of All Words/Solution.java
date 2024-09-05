class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        // Calculate the total length of all words
        int totalLength = words.length * words[0].length();

        // If the length of s is less than the total length of all words, there can't be any concatenated substring
        if (s.length() < totalLength) {
            return result;
        }

        // Create a map to store the count of each word
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Iterate through the string s and check for concatenated substrings
        for (int i = 0; i <= s.length() - totalLength; i++) {
            Map<String, Integer> currentCount = new HashMap<>(wordCount);
            int j = 0;
            while (j < words.length) {
                String currentWord = s.substring(i + j * words[0].length(), i + (j + 1) * words[0].length());
                if (!currentCount.containsKey(currentWord) || currentCount.get(currentWord) == 0) {
                    break;
                }
                currentCount.put(currentWord, currentCount.get(currentWord) - 1);
                j++;
            }
            if (j == words.length) {
                result.add(i);
            }
        }

        return result;
    }
}