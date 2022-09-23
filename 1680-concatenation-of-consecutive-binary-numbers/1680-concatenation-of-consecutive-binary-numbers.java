class Solution {
    public int concatenatedBinary(int n) {
        
        int answer = 0;
        int power = 1;
        int mod = 1000000007; //10^9 + 7
        
        for(int i = n; i>0; i--){
            int current = i;
            while(current > 0){
                int num = current&1; //for converting char '0' -> 0 int
                
                answer = answer%mod + num*power;
                
                power = (power*2)%mod;
                current >>= 1;
            }
        }

        
        return answer%mod;
    }
}