class Solution {
    public boolean ifMatches(String str, String pattern){
            Map<Character, Character> curr = new HashMap();
            
            for(int i = 0; i<str.length(); i++){
                char c = str.charAt(i);
                char p = pattern.charAt(i);
                
                if(curr.containsKey(c)){
                    if(curr.get(c) != p){
                        return false;
                    }
                } else {
                    curr.put(c, p);
                }
            }
        
            boolean []seen = new boolean[26];    
            for(char c: curr.values()){
                if(seen[c-'a']){
                    return false;
                } else {
                    seen[c-'a'] = true;
                }
            }
        
        return true;
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList();

        for(String str: words){
            
            
            if(ifMatches(str, pattern)){
                ans.add(str);
            }
    
        }
        
        return ans;
    }
}