class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int lenMaxSubarray = 0;
        //loop for first array
        for(int i = 0; i<len1; i++){
            for(int j = 0; j<len2; j++){
                if(nums1[i] != nums2[j]){
                    continue;
                }
                
                int tempi = i, tempj = j;
                int matchedLen = 0;
                while(tempi < len1 && tempj < len2 && nums1[tempi] == nums2[tempj]){
                    tempi++;
                    tempj++;
                    matchedLen++;
                }

                if(lenMaxSubarray < matchedLen){
                    lenMaxSubarray = matchedLen;
                }
            }
        }
        
        return lenMaxSubarray;
    }
}