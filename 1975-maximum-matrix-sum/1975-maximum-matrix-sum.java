class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long no_of_neg = 0;
        long abs_sum = 0;
        long min_num = Integer.MAX_VALUE;
        
        for(int[] arr: matrix){
            for(int num: arr){
                if(num < 0)
                    no_of_neg++;
                abs_sum += Math.abs(num);
                min_num = Math.min(min_num, Math.abs(num));
            }
        }
        
        return abs_sum - (no_of_neg % 2 == 0? 0: min_num * 2);
    }
}