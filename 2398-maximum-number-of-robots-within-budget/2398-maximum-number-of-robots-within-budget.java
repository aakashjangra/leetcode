class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        //will store index instead of element as that will be unique
        Deque<Integer> deque = new LinkedList<>();
        int robots = 0;
        int n = chargeTimes.length;
        
        int i = 0; 
        int j = 0;
        
        long sumRc = 0;
        
        while(j < n){
            while( !deque.isEmpty() && chargeTimes[deque.getLast()] <= chargeTimes[j]){
                deque.pollLast();
            }
            deque.addLast(j);
            
            sumRc += runningCosts[j];
            int k = j-i+1; //counting choosen no. of robots
            int bigIndex = deque.getFirst();
            
            if(chargeTimes[bigIndex]+(k*sumRc) > budget){
                if(bigIndex == i){
                    deque.pollFirst();
                }
                sumRc -= runningCosts[i];
                i++;
            }
            
            robots = Math.max(robots, j-i+1);
            j++;
        }
        
        return robots;
    }
}