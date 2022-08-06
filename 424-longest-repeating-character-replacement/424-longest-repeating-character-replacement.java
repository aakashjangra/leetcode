class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int i = 0;
        int j = 0; 
        int maxC = 0;
        int ans = 0;
        int []freq = new int[26];
        
        while(j < n){
            char charj = s.charAt(j);
            freq[charj-'A']++;
            maxC = Math.max(maxC, freq[charj-'A']);
            int curLen = j - i + 1;
            
            if(curLen - maxC > k){
                char chari = s.charAt(i);
                freq[chari-'A']--;
                i++;
            }
            curLen = j - i + 1;
            ans = Math.max(ans, curLen);
            j++;
        }
        
        return ans;
    }
}