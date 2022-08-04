class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int c = 1;
        for(int i = len-1; i>= 0; i--){
            int n = digits[i];
            n = n+c;
            c = n/10;
            n = n % 10;
            digits[i] = n;
        }
        if(c == 0)
            return digits;
        
        int []arr = new int[len+1];
        for(int i = len-1; i>= 0; i--){
            arr[i+1] = digits[i];
        }
        arr[0] = 1;

        return arr;
    }
}