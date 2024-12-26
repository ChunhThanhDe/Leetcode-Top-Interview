/*
 * @ Author: Chung Nguyen Thanh <chunhthanhde.dev@gmail.com>
 * @ Created: 2024-07-02 16:49:52
 * @ Message: 🎯 Happy coding and Have a nice day! 🌤️
 */

// input: Array of String strs
// output list of sublist contains group string rearranging character

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution{
    public List<List<String>> groupAnagrams(String[] strs){
        // Create a Map to store sorted String as key
        // and their anagrams as values
        Map<String, List<String>> anagramsMap = new HashMap<>();

        //iterate over each string in the input array
        for (String str : strs){
            // Convert the String to a charArray to sort its characters
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray); //soft the characters in ABC order

            // create a String from sort character ABC order
            String sortedStr = new String(charArray);

            // if the sorter String is not in the map, initialize an empty list
            anagramsMap.putIfAbsent(sortedStr, new ArrayList<>());

            // add the original string to the list of Hashmap key sorted string
            anagramsMap.get(sortedStr).add(str);

        }

        // return all group string anagrams together as a list<list<string>>
        return new ArrayList<>(anagramsMap.values());
    }
}