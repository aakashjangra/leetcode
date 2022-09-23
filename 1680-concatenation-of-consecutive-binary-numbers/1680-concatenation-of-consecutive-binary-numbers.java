class Solution {
    public int concatenatedBinary(int n) {
        
        long answer = 1;
        int mod = 1000000007; //10^9 + 7
        
        for(int i = 2; i<=n; i++){
            int length = (int)(Math.log(i)/Math.log(2)) + 1;
            answer = ((answer<<length) + i)%mod;
        }

        
        return (int)answer;
    }
}