class LRUCache {
    //doubly linked list
    class Node{
        int val;
        int key;
        Node prev;
        Node next;

        Node(int k, int v){
            key = k;
            val = v;
        }
    }
    
    HashMap<Integer, Node> hm;
    
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int cap = 0;
    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
        hm = new HashMap<>();
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node curr = hm.get(key);
            del(curr);
            insert(curr);
            return curr.val;
        }  
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            del(hm.get(key));
            hm.remove(key);
        }
        if(hm.size() == cap){
            hm.remove(tail.prev.key);
            del(tail.prev);
        }
        Node newNode = new Node(key, value);
        hm.put(key, newNode);
        insert(newNode);
    }
    
    public void insert(Node node){
        Node n = head.next;
        head.next = node;
        node.prev = head;
        node.next = n;
        n.prev = node;
    }
    
    public void del(Node node){
   
        node.prev.next = node.next;
        node.next.prev = node.prev;
    
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */