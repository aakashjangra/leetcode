class Solution {
    private int getValue(char c){
        switch(c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                    return 10;
            case 'L':
                return 50;
            case 'C':
                    return 100;
            case 'D':
                return 500;
            case 'M':
                    return 1000;
            default:
                return -1;
        }
           
    }
    public int romanToInt(String s) {
        int num = 0;
   
        int n = s.length();
        for(int i = 0; i<n-1; i++){
            int curr = getValue(s.charAt(i));
            int next = getValue(s.charAt(i+1));
            if(curr < next)
                num -= curr;
            else 
                num += curr;
        }
        num += getValue(s.charAt(n-1));
        
        return num;
    }
}