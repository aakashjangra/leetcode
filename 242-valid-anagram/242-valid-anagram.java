class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
       
        int []arr = new int[26];
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            char d = t.charAt(i);
            ++arr[c - 'a'];
            --arr[d - 'a'];
        }
        
        for(int val: arr){
            if(val != 0)
                return false;
        }
        
        return true;
    }
}