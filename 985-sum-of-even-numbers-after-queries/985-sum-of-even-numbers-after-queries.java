class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length; 
        //for m queries, answer for each will be stored in this
        int[] answer = new int[m];
        
        //calculating evenSum for current state
        int evenSum = 0;
        for(int a: nums){
            if((a & 1) == 0)
                evenSum += a;
        }
        
        //running queries and calculating evenSum for each and storing that in answer[]
        for(int i = 0; i<m; i++){
            int val = queries[i][0];
            int index = queries[i][1];
            
            //getting value at index "index" in nums[]
            int prevVal = nums[index];
            //if prev value was even, subtract it from totalEven sum before this query
            if((prevVal & 1) == 0)
                evenSum -= prevVal;
            
            //new value creation
            int newVal = prevVal + val;
            
            //assing newVal to nums[index] i.e. nums[index] = newVal
            nums[index] = newVal;
            
            //if newVal is even then add it to evenSum
            if((newVal & 1) == 0)
                evenSum += newVal;
            
            //finally add evenSum that is after running the query provided to us
            answer[i] = evenSum;
        }
        
        return answer;
    }
}