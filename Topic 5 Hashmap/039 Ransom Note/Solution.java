import java.util.HashMap;
import java.util.Map;

// input:  two strings ransomNote and magazine,
// output: true if ransomNote can be constructed by using the letters from magazine and false otherwise.

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine){
        // create a map to count character from magazine
        Map<Character, Integer> charCountMap = new HashMap<>();

        // map the character of magazine to charCountMap
        for (char c : magazine.toCharArray()){
            if (charCountMap.containsKey(c)){
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        // check if ransomNote can be built by use magazine
        for (char c : ransomNote.toCharArray()){
            if (charCountMap.containsKey(c) && charCountMap.get(c) > 0){
                charCountMap.put(c, charCountMap.get(c) - 1);
            } else {
                return false;
            }
        }

        // return true if ransomNote can constructed
        return true;
    }
}