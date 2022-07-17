class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();

        int carry = 0;
        for(int i = num.length-1; i>=0; i--){
            int c = num[i];    
            int res = k%10;
            k = k/10;
            int sum = c+res+carry;
            
            ans.add(0, sum%10);
            carry = sum/10;
            
        }
        
        while(k != 0){
            int rem = k % 10;
            rem = rem + carry;
            ans.add(0, rem%10);
            carry = rem/10;
            k = k/10;
        }
        
        if(carry != 0){
            ans.add(0, carry);
        }

 
        return ans;
    }
}