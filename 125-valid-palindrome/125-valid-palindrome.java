class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        
        String onlyLowerCase = s.toLowerCase();
        
        String onlyLowerAlphanum = "";
        
        for(int i = 0; i<n; i++){
            char c = onlyLowerCase.charAt(i);
            if((48 <= c && c <= 57) || (97 <= c && c <= 122))
                onlyLowerAlphanum = onlyLowerAlphanum + c;
        }

        int front = 0;
        int back = onlyLowerAlphanum.length() - 1;
        
        while(front < back){
            if(onlyLowerAlphanum.charAt(front) != onlyLowerAlphanum.charAt(back))
                return false;
            front++;
            back--;
        }
        
        return true;
    }
}