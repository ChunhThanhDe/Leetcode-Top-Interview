class Solution {
    // Function that converts an integer to its corresponding Roman numeral representation.
    public String intToRoman(int num) {
        // Array holding Roman numeral symbols in descending order of their values.
        // These include combinations like "CM" for 900 and "IV" for 4, which represent subtractive forms.
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        // Array holding the integer values corresponding to the Roman numeral symbols.
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        // We use a StringBuilder to efficiently append Roman numeral characters as we build the result.
        StringBuilder romanNumeral = new StringBuilder();
        
        // Index variable 'i' to traverse through the symbols and values arrays.
        int i = 0;
        
        // While 'num' is still greater than 0, we continue converting the integer into its Roman form.
        while (num > 0) {
            // Check if the current integer is greater than or equal to the value at index 'i'.
            // If it is, we can subtract this value from 'num' and append the corresponding symbol.
            if (num >= values[i]) {
                // Append the corresponding Roman symbol to the result.
                romanNumeral.append(symbols[i]);
                
                // Reduce the number by the current Roman numeral's value.
                num -= values[i];
            } else {
                // If the current value at index 'i' is too large, move to the next smaller value.
                i++;
            }
        }
        
        // Finally, return the built Roman numeral string.
        return romanNumeral.toString();
    }
}
