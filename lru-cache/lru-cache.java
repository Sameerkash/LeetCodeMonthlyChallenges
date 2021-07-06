class LRUCache {

    
    Node head = new Node(0, 0), tail = new Node(0, 0);
    
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;   
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        
            Node data = map.get(key);
            // Remove the data
            remove(data);
            // add it to top
            add(data);
            return data.value;
        }
        
        return -1;
        
    }
       
    public void put(int key, int value) {
        // if value is already present
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        
        if(capacity == map.size()){
            remove(tail.prev);
        }    
        
        add(new Node(key, value));
    }
    
    void add(Node node){
        map.put(node.key, node);
        
        // add the node to the topmost location
        Node headNext = head.next;

        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }
    
    void remove(Node node){
        map.remove(node.key);
        
        // remove the node 
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    class Node{
        int key, value;
        Node prev, next;
        
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */