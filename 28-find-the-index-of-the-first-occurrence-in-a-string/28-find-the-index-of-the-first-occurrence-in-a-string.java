class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        if(haystack.length() < needle.length())
            return -1;
        
        for(int i = 0; i<=n-needle.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                boolean matched = true;
                for(int j = 0; j<needle.length(); j++){
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        matched = false;
                        break;
                    }
                }
                if(matched)
                    return i;
            }
        }
        
        return -1;
    }
}