class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack = new Stack<>();
        int []ans =  new int[temp.length];
        
        for(int i = temp.length-1; i>=0; i--){
            int curr = temp[i];
            while(stack.size() > 0 && temp[stack.peek()] <= curr){
                stack.pop();
            }
            
            if(stack.isEmpty())
                ans[i] = 0;
            else 
                ans[i] = stack.peek() - i;
            
            stack.push(i);
        }
        
        return ans;
    }
}