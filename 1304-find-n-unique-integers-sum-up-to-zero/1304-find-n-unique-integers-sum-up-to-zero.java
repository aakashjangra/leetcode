class Solution {
    public int[] sumZero(int n) {
        int []ans = new int[n];
        
        int num = 1;
        int sum = 0;
        for(int i = 0; i<n-1; i++){
            sum += num;
            ans[i] = num++;
        }

        
        ans[n-1] = -sum;
        
        return ans;
    }
}
