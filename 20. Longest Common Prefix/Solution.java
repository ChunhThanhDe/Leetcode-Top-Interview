class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        
        // set prefix = first String
        String prefix = strs[0];
        
        // loop all String
        for (int i = 1; i < strs.length; i++) {

            //check String with prefix
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            
            if (prefix.isEmpty()) {
                break;
            }
        }
        
        return prefix;
    }
}