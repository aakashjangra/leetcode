class Solution {
    private void createLPS(int[] lps, String pattern, int m){
        int cur = 1;
        int ptr = 0;
        
        while(cur < m){
            if(pattern.charAt(cur) == pattern.charAt(ptr)){
                ptr++;
                lps[cur] = ptr;
                cur++;
            } else {
                if(ptr == 0){
                    lps[cur] = 0;
                    cur++;
                } else {
                    ptr = lps[ptr-1];
                }
            }
        }
    }
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        
        if(n < m)   return -1;
        
        int[] lps = new int[m];
        createLPS(lps, needle, m);
        
        //finding needle in haystack using lps
        int sp = 0; //string pointer
        int pp = 0; //pattern pointer
        
        // for(int  a: lps){
        //     System.out.print(a+" ");
        // }
        // System.out.println();
        
        while(sp < n){
            if(haystack.charAt(sp) == needle.charAt(pp)){
                sp++;
                pp++;
            } else {
                if(pp == 0){
                    sp++;
                } else {
                    pp = lps[pp-1]; 
                }
            }
            
            if(pp == m)
                return sp-pp;
        }
        
        return -1;
    }
}