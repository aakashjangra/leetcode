class Solution {
    private int[][] dp;
//     private int tryCombinations(int i, int j, int[] nums1, int[] nums2){
//         if(i >= nums1.length || j >= nums2.length || nums1[i] != nums2[j]){
//             return 0;
//         }
        
//         if(dp[i][j] != -1)
//             return dp[i][j];
        
//         return dp[i][j] = 1 + tryCombinations(i+1, j+1, nums1, nums2);
//     }
    public int findLength(int[] nums1, int[] nums2) {
        int maxLen = 0;
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        dp = new int[len1+1][len2+1];
        
        for(int i = len1-1; i>=0; i--){
            for(int j = len2-1; j>=0; j--){
                
                if(nums1[i] != nums2[j]){
                    continue;    
                }
                
                dp[i][j] = 1 + dp[i+1][j+1];
                
                if(maxLen < dp[i][j])  maxLen = dp[i][j];
            }
        }    
        
        return maxLen;
    }
}