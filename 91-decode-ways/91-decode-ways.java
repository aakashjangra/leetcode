class Solution {
    private int calcCombinations(int index, int size, int[] encoded, int[] dp){
        
        if(index == size){
            return 1;
        }
        
        if(encoded[index] == 0){
            return 0;
        }
        
        //taking only one
        int ans = 0;
        if(dp[index+1] == -1)
            dp[index+1] = calcCombinations(index+1, size, encoded, dp);
        
        ans = dp[index+1];
        //taking two at a time
        // 1, 2 || 9, 19
        if(index+1 < size && (encoded[index] == 1 || (encoded[index] == 2 && encoded[index+1] <= 6)) ){
            if(dp[index+2] == -1)
                dp[index+2] = calcCombinations(index+2, size, encoded, dp);                     ans += dp[index+2];
        }
        
        dp[index] = ans;
        
        return dp[index];
    }
    
    public int numDecodings(String s) {
        int size = s.length();
        
        int[] encoded = new int[size];
        for(int index = 0; index < size; index++){
            encoded[index] = s.charAt(index)-'0'; /* '0'-'0'== 0, '1'-'0'== 1 and so on... */
        }
        
        int[] dp = new int[size+1];
        Arrays.fill(dp, -1);
        
        return calcCombinations(0, size, encoded, dp);
    }
}