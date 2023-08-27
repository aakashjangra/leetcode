class Solution {
    public long minimumPossibleSum(int n, int target) {
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        int num = 1;
        while(set.size() < n){
           if(set.contains(target - num) == false){
                sum += num;
                set.add(num);
           } 
            num++;
        }
    
        return sum;
    }
}