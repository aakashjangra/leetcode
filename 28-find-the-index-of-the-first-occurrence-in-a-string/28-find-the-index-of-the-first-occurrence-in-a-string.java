class Solution {
    // all the character are lowercase so taking a prime no 127(more than double of character set)
    int prime = 127;
    public long calPower(int n, int p){
        if(p == 0)
            return 1;
        long pow = n;
        while(p > 1){
            pow *= n;
            p--;
        }
        
        return pow;
    }
    public long  getHash(String pattern) {
        
        int plength = pattern.length();
        int power = plength -1;
        long hash = 0;
         for (int i =0; i<plength ;i++) {
            int ch = pattern.charAt(i) - 97;
            hash += calPower(prime,power-- )*ch;
        }
            
        return hash;
    }

    public int strStr(String haystack, String needle) {
        System.out.println("a test case");
        
        if(haystack.length() < needle.length())
            return -1;
        
        int k = needle.length();    //size of pattern
        int start =0, end = k;      //first size of pattern
        int len = haystack.length();    //len = size of str
        long patternHash = getHash(needle);   //hash of pattern(double)
        // System.out.println(patternHash);
        
        String substr = haystack.substring(0, k);   // first substring of k size
        // System.out.println(substr);
        long strHash = getHash(substr);       //hash of first substring
        
        long highestpow = calPower(prime, k-1);   //highest power
        if (patternHash == strHash) //checking if first substr is equal to pattern
            return 0;
        
        while (end<len) {   //while end < len, keep window moving
            
            strHash = (strHash -((int)(haystack.charAt(start)) - 97)* highestpow) *prime +((int)(haystack.charAt(end)) -97);        
            
            // System.out.println(strHash);
            
            if (patternHash == strHash)
                return start+1;
            
            start++;
            end++;
        }
        return -1;
    }
}