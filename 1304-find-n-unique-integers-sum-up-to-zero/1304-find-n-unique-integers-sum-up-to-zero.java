class Solution {
    public int[] sumZero(int n) {
        int []ans = new int[n];
        
        int num = 1;
        for(int i = 0; i<n-1; i++){
            ans[i] = num++;
        }
        
        int sum = ((num)*(num-1))/2;
        
        ans[n-1] = -sum;
        
        return ans;
    }
}
