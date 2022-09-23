class Solution {
    public int concatenatedBinary(int n) {
        
        int answer = 0;
        int power = 1;
        int mod = 1000000007; //10^9 + 7
        
        for(int i = n; i>0; i--){
            String bin = Integer.toBinaryString(i);
            int len = bin.length();
            for(int j = len-1; j>=0; j--){
                int num = bin.charAt(j) - '0'; //for converting char '0' -> 0 int
                
                answer = answer%mod + num*power;
                
                power = (power*2)%mod;
            }
        }

        
        return answer%mod;
    }
}