class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> que;
    public MyQueue() {
        st1 = new Stack<Integer>();
        que = new Stack<Integer>();
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        if(que.isEmpty()){
            while(!st1.isEmpty()){
                que.push(st1.pop());
            }
        }
        return que.pop();
    }
    
    public int peek() {
        if(que.isEmpty()){
            while(!st1.isEmpty()){
                que.push(st1.pop());
            }
        }
        return que.peek();     //top
    }
    
    public boolean empty() {
        return st1.isEmpty() && que.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */