class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int ans = 0;
        int end = intervals[0][1];
        
        // for(int []a: intervals){
        //     for(int el: a){
        //         System.out.println(el+" ");
        //     }
        //     System.out.println();
        // }
        
        for(int i = 1; i<intervals.length; i++){
            if(end > intervals[i][0]){
                ++ans;
                end = Math.min(end, intervals[i][1]);
            } else {
                end = intervals[i][1];
            }
        }  
        
        return ans;
    }
}