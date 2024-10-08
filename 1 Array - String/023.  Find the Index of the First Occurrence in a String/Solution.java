class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()){
            return 0;
        }

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        for (int i = 0; i <= haystackLength - needleLength; i++){
            if(haystack.substring(i, i + needleLength).equals(needle)){
                return i;
            }
        }

        return -1;
    }
}