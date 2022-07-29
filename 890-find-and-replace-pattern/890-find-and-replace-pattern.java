class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList();

        for(String str: words){
            Map<Character, Character> patt = new HashMap();
            Map<Character, Character> curr = new HashMap();
            
            boolean flag = true;
            
            for(int i = 0; i<str.length(); i++){
                char c = str.charAt(i);
                char p = pattern.charAt(i);
                if(patt.containsKey(p)){
                    if(patt.get(p) != c){
                        flag = false;
                    }
                } else {
                    patt.put(p, c);
                }
                if(curr.containsKey(c)){
                    if(curr.get(c) != p){
                        flag = false;
                    }
                } else {
                    curr.put(c, p);
                }
            }
            
            if(flag){
                ans.add(str);
            }
    
        }
        
        return ans;
    }
}