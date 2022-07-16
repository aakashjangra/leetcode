class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        
        int []left = new int[n];
        int []right = new int[n];
        
        left[0] = height[0];
        right[n-1] = height[n-1];
        
        int max = Integer.MIN_VALUE;
        for(int i = 1; i<n; i++){
            max = Math.max(max, height[i-1]);
            left[i] = max;
        }
        max = Integer.MIN_VALUE;
        for(int i = n-2; i>=0; i--){
            max = Math.max(max, height[i+1]);
            right[i] = max;
        }

        for(int i = 0; i<n; i++){
            int curr = Math.min(left[i], right[i]);
            curr = curr - height[i];
            
            if(curr > 0){
                ans += curr;
            }
            
        }
        
        return ans;
    }
}