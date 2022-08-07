class Solution {
    private boolean alphaNumeric(char c){
        if((48<=c && c<=57) || (97 <= c && c <= 122))
            return true;
        return false;
    }
    public boolean isPalindrome(String s) {
        int n = s.length();
        s = s.toLowerCase();
        int front = 0;
        int back = n - 1;
        
        while(front < back){
        
            while(front < n-1 && !Character.isLetterOrDigit(s.charAt(front)))
                front++;
            
            while(back > 0 && !Character.isLetterOrDigit(s.charAt(back)))
                back--;
            
            if(front > back)
                break;
            
            
            if(s.charAt(front) != s.charAt(back))
                return false;
            front++;
            back--;
        }
        
        return true;
    }
}