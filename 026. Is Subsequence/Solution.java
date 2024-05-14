class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        List<Character> sChars = new ArrayList<>();
        
        for (char c : s.toCharArray()) {
            sChars.add(c);
        }

        for (char c : t.toCharArray()) {
            // check with each character of t
            if (sChars.isEmpty()) return true;

            if (!sChars.isEmpty() && c == sChars.get(0)) {
                sChars.remove(0);
            }
        }

        return sChars.isEmpty();
    }
}