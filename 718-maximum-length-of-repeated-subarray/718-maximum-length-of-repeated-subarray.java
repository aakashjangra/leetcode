class Solution {
    private int[][] memo;
    private int rec(int i, int j, int[] nums1, int[] nums2){
            if(i >= nums1.length || j >= nums2.length || nums1[i] != nums2[j]){
                return 0;
            }
        
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        
        return memo[i][j] =  1 + rec(i+1, j+1, nums1, nums2);
    }
    
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        memo = new int[len1+1][len2+1];
        
        for(int i = 0; i<len1+1; i++){
            Arrays.fill(memo[i], -1);
        }
        
        int lenMaxSubarray = 0;
        //loop for first array
        for(int i = 0; i<len1; i++){        
            //loop for second array
            for(int j = 0; j<len2; j++){    

                int matchedLen = rec(i, j, nums1, nums2);

                if(lenMaxSubarray < matchedLen){
                    lenMaxSubarray = matchedLen;
                }
            }
        }
        
        return lenMaxSubarray;
    }
}