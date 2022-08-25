class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for(int i = 0; i<ransomNote.length(); i++){
            freq[ransomNote.charAt(i) - 'a']--;
        }
        for(int i = 0; i<magazine.length(); i++){
            freq[magazine.charAt(i) - 'a']++;
        }
        
        
        for(int a: freq){
            if(a < 0)
                return false;
        }
        return true;
    }
}