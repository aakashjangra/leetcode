class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(p.length() == 0) return ans;
        
        int[] freq = new int[26];
        for(int i = 0; i<p.length(); i++){
            freq[p.charAt(i) - 'a']++;
        }
        
        int i = 0;
        int j = 0;
        int n =s.length();
        int count = p.length();
        
        while(j < n){
            
            if(freq[s.charAt(j++) - 'a']-- >= 1)    count--;
            
            if(count == 0)  ans.add(i);
            
            if(j - i + 1 > p.length() && freq[s.charAt(i++) - 'a']++ >= 0)
                count++;
            
        }
        
        return ans;
    }
}