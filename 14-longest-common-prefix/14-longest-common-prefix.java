class Solution {
    public String longestCommonPrefix(String[] strs) {
        //finding smallest length
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<strs.length; i++){
            if(min > strs[i].length())
                min = strs[i].length();
        }
        
        int index = 0;
        boolean flag = false;
        for(int i = 0; i<min; i++){
            for(int j = 0; j<strs.length; j++){
                if(strs[j].charAt(i) != strs[0].charAt(i)){
                  flag  = true;
                } 
            }
            if(flag)
                break;
            
            ++index;
        }
        
       String result = "";
        if(index <= 0){
            return "";
        }
        String str = strs[0];
        for(int i =0; i<index; i++){
            result += str.charAt(i);
            
        }
        return result;
    }
}