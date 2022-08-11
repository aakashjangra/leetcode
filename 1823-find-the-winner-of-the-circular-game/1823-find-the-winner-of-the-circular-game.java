class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 1; i<=n; i++){
            q.offer(i);
        }
        
        while(q.size() > 1){
            int counter = k;
            while(counter > 1){
                q.offer(q.poll());
                counter--;
            }
            q.poll();
        }
        
        return q.peek();
    }
}