class LFUCache {
    class Node {
        int key, value, cnt;
        Node next;
        Node prev;

        Node(int _key, int _value) {
            key = _key;
            value = _value;
            cnt = 1;
        }
    }

    // To implement the doubly linked list
    class List {
        int size; // Size 
        Node head; // Dummy head
        Node tail; // Dummy tail

        // Constructor
        List() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // Function to add node in front
        void addFront(Node node) {
            Node temp = head.next;
            node.next = temp;
            node.prev = head;
            head.next = node;
            temp.prev = node;
            size++;
        }

        // Function to remove node from the list
        void removeNode(Node delnode) {
            Node prevNode = delnode.prev;
            Node nextNode = delnode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
    }

    Map<Integer, Node> keyNode;
    Map<Integer, List> freqList;
    int minFreq;
    int maxSize;

    public LFUCache(int capacity) {
        maxSize = capacity;
        keyNode = new HashMap<>();
        freqList = new HashMap<>();
    }

    void UpdateFreqList(Node node){
        keyNode.remove(node);
        freqList.get(node.cnt).removeNode(node);
        if(node.cnt == minFreq && freqList.get(node.cnt).size == 0){
            minFreq++;
        }
        List nextHigherFreqList = new List();

        if(freqList.containsKey(node.cnt + 1)){
            nextHigherFreqList = freqList.get(node.cnt + 1);
        }
        node.cnt += 1;
        nextHigherFreqList.addFront(node);
        freqList.put(node.cnt, nextHigherFreqList);
        keyNode.put(node.key, node);
    }

    public int get(int key) {
        if(keyNode.containsKey(key)){
            Node node = keyNode.get(key);
            UpdateFreqList(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(keyNode.containsKey(key)){
            Node node = keyNode.get(key);
            node.value = value;
            UpdateFreqList(node);
        }
        else{
            if(keyNode.size() == maxSize){
                List list = freqList.get(minFreq);
                keyNode.remove(list.tail.prev.key);
                freqList.get(minFreq).removeNode(list.tail.prev);
            }
            minFreq = 1;
            List listFreq = new List();
            if (freqList.containsKey(minFreq)) {
                // Update the pointer to already present list
                listFreq = freqList.get(minFreq);
            }
            
            // Create the node to store data-item
            Node node = new Node(key, value);
            
            // Add the node to dummy list
            listFreq.addFront(node);
            
            // Add the node to Hashmap
            keyNode.put(key, node);
            
            // Update the frequency list map
            freqList.put(minFreq, listFreq);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */