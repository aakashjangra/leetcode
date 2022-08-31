class Solution {
    private void helper(int n, int open, int closed, String str, List<String> ans){
        if(open == n && closed == n){
            ans.add(str);
            return;
        }
        
        if(closed > open || open > n)
            return;
        
        helper(n, open+1, closed, str+'(', ans);
        helper(n, open, closed+1, str+')', ans);    
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, 0, 0, "", ans);
        return ans;
    }
}