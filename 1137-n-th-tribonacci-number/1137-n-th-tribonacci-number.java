class Solution {
    private int[] t = new int[37+1];
    public int tribonacci(int n) {
        if(n < 2)
            return n;
        if(n == 2)
            return 1;
        
        if(t[n-1] == 0)
            t[n-1] = tribonacci(n-1);
            
        
        if(t[n-2] == 0)
            t[n-2] = tribonacci(n-2);
        
        if(t[n-3] == 0)
            t[n-3] = tribonacci(n-3);
        
        return t[n-1] + t[n-2] + t[n-3];
    }
}