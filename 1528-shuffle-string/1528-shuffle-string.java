class Solution {
    public String restoreString(String s, int[] indices) {
        int size = indices.length; 
        char[] ans = new char[size];
        
        for(int i = 0; i<size; i++){
            ans[indices[i]] = s.charAt(i);
        }
        
        String str = new String(ans);
        return str;
        
    }
}