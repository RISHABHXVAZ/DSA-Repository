class MedianFinder {
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    public MedianFinder() {
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
        minheap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxheap.add(num);
        minheap.add(maxheap.poll());

        if(maxheap.size() < minheap.size()){
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        int size = maxheap.size() + minheap.size();
        
        if(size % 2 != 0) return maxheap.peek();
        return (maxheap.peek() + minheap.peek())/2.0; 
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */