class Solution {
    public int[] asteroidCollision(int[] ast) {
        int n = ast.length;
        
        Deque<Integer> st = new ArrayDeque<>();
        
        for(int i = 0; i<n; i++){
            boolean nCollided = true;
            //while stack has some elements and top of stack is positive
            int current = ast[i];
            while(current < 0 && !st.isEmpty() && st.peekLast() > 0){
                int pos = st.peekLast();
                int neg = Math.abs(current);
                if(pos < neg){
                    st.pollLast();
                } else if(neg < pos){
                    nCollided = false;
                    break;
                } else {
                    st.pollLast();
                    nCollided = false;
                    break;
                }
            }
            
            if(nCollided){
                st.offerLast(current);
            }
        }

        
        int idx = st.size()-1;
        int[] ans = new int[idx+1];
        
        while( !st.isEmpty() ){
            ans[idx--] = st.pollLast();
        }

        return ans;
    }
}