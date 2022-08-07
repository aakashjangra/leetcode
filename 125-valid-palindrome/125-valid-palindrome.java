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
          
            while(front < n-1 && alphaNumeric(s.charAt(front)) == false)
                front++;
            
            while(back > 0 && alphaNumeric(s.charAt(back)) == false)
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