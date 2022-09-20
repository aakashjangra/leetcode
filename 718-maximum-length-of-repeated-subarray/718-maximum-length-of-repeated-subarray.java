class Solution {
    private int[][] dp;
    
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        // TC= O(len1*len2), SC= O(1)
            
        dp = new int[len1+1][len2+1];
        
        int lenMaxSubarray = 0;
        //loop for first array
        for(int i = len1-1; i>=0; i--){        
            //loop for second array
            for(int j = len2-1; j>=0; j--){    

                if(nums1[i] == nums2[j]){
                    dp[i][j] =  1 + dp[i+1][j+1];
                }
                    
                if(lenMaxSubarray < dp[i][j]){
                    lenMaxSubarray = dp[i][j];
                }

            }
        }
        
        return lenMaxSubarray;
    }
}