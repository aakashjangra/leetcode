class MyCircularQueue {
    int[] cQueue;
    int front = -1; //index
    int rear = -1; //index
    int size;
    public MyCircularQueue(int k) {
        cQueue = new int[k];
        this.size = k;
    }
    
    public boolean enQueue(int value) {
        if(rear == front-1 || (front == 0 && rear == size-1)){
            // System.out.println(front+" "+rear);
            return false;
        }
    
        if(rear == size-1){
            rear = 0;
            cQueue[rear] = value;
        }else{
            rear++;
            cQueue[rear] = value;
        }
        
        if(front == -1)
            front = rear; 
        
        
        return true;
    }
    
    public boolean deQueue() {
        if(front == -1){        //no elements are there
            return false; 
        }
        
        if(front == rear){
            //if only one element exists
            front = -1;
            rear = -1;
        } else {
            // if front index is last index
            if(front == this.size - 1){
                front = 0;
            } else {
                front++;                            
            }
        }
        
        
        return true;
    }
    
    public int Front() {
        if(front == -1)
            return -1;
        else 
            return cQueue[front];
    }
    
    public int Rear() {
        if(rear == -1)
            return -1;
        else 
            return cQueue[rear];
    }
    
    public boolean isEmpty() {
        if(front == -1 && rear == -1)
            return true;
        else 
            return false;
    }
    
    public boolean isFull() {
        if(rear == front-1 || (front == 0 && rear == size-1))
            return true;
        else 
            return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */