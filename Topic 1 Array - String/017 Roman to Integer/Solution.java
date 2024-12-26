/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-05-24 16:20:41
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        // Create a HashMap to store Roman numeral symbols and their corresponding
        // integer values Using Map instead of HashMap allows for greater flexibility
        // and adherence to object-oriented principles
        Map<Character, Integer> symbolValues = new HashMap<>();

        // initialize roman numerals key and value
        symbolValues.put('I', 1);
        symbolValues.put('V', 5);
        symbolValues.put('X', 10);
        symbolValues.put('L', 50);
        symbolValues.put('C', 100);
        symbolValues.put('D', 500);
        symbolValues.put('M', 1000);

        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            // get the current Roman numerals's integer value
            int current = symbolValues.get(s.charAt(i));

            // if the next numeral is langer, it mean we should subtract the current value
            if (i + 1 < s.length() && current < symbolValues.get(s.charAt(i + 1))) {
                // subtract current value from total
                total -= current;
            } else {
                // add current value to total
                total += current;
            }
        }

        return total;
    }
}