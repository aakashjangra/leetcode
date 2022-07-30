class Solution {
    public int[] countCharacters(String s){
        int []arr = new int[26];
            for(int i = 0; i<s.length(); i++){
                char c = s.charAt(i);
                arr[c-'a']++;
            }
        return arr;
    }
    
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList();
        
        int []compareWith = new int[26];
        
        for(String str: words2){
            int []curr = countCharacters(str);
            
            for(int i = 0; i<26; i++){
                compareWith[i] = Math.max(compareWith[i], curr[i]);
            }
        }
        
        for(String str: words1){
            int []curr = countCharacters(str);
            boolean flag = true;
            for(int i = 0; i<26; i++){
                if(compareWith[i] > curr[i]){
                    flag = false;
                }
            }
            if(flag){
                ans.add(str);
            }
        }
        
        return ans;
    }
}