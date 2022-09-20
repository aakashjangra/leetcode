class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int maxLen = 0;
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        for(int i = 0; i<len1; i++){
            for(int j = 0; j<len2; j++){
                int len = 0;
                int ptr1 = i;
                int ptr2 = j;
                
                while(ptr1 < len1 && ptr2 < len2 && nums1[ptr1] == nums2[ptr2]){
                    len++;
                    ptr1++;
                    ptr2++;
                }
                
                maxLen = Math.max(maxLen, len);
            }
        }
        
        return maxLen;
    }
}