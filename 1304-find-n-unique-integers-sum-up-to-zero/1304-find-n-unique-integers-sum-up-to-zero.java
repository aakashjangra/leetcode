class Solution {
    public int[] sumZero(int n) {
        int []ans = new int[n];
        if(n % 2 != 0){
            ans[n-1] = 0;
            n--;
        }
        int num = 1;
        for(int i = 0; i<n; i += 2){
            ans[i] = num;
            ans[i+1] = -num;
            num++;
        }
        
        return ans;
    }
}
