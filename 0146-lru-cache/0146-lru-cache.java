class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int val){
            this.key = key;
            this.value = val;
        }
    }
    HashMap<Integer,Node> mpp = new HashMap<>();
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int size = 0;
    int capacity;
     void insertAfterHead(Node node){
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }
    void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(mpp.containsKey(key)){
            Node node = mpp.get(key);
            deleteNode(node);
            insertAfterHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(mpp.containsKey(key)){
            Node node = mpp.get(key);
            node.value = value;
            deleteNode(node);
            insertAfterHead(node);
        }
        else{
            Node node = new Node(key,value);
            if(mpp.size() == capacity){
                mpp.remove(tail.prev.key);
                deleteNode(tail.prev);
                insertAfterHead(node);
                mpp.put(key,node);
            }
            else{
                insertAfterHead(node);
                mpp.put(key,node);
                size++;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */