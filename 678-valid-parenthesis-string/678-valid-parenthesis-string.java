class Solution {
    public boolean checkValidString(String s) {
        
        int l = s.length();
        int low = 0, high = 0;
        
        for(int i =0; i<l; i++){
            char c = s.charAt(i);
            
            if(c == '('){
                low++;
                high++;
            } else if(c == ')'){
                if(low > 0){
                    low--;
                }
                high--;
            } else {
                if(low > 0)
                    low--;
                high++;
 
            }
            
                           
                if(high < 0)
                    return false;
        }
        
        return low == 0;
    }
}