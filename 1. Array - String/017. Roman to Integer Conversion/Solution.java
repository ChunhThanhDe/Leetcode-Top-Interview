class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> symbolValues = new HashMap<>();
        symbolValues.put('I', 1);
        symbolValues.put('V', 5);
        symbolValues.put('X', 10);
        symbolValues.put('L', 50);
        symbolValues.put('C', 100);
        symbolValues.put('D', 500);
        symbolValues.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = symbolValues.get(s.charAt(i));

            if (i + 1 < s.length() && value < symbolValues.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }

        return result;
    }
}