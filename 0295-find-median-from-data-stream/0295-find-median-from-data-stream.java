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

        if(minheap.size() > maxheap.size()){
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        double ans = 0;
        if(maxheap.size() == minheap.size()){
            ans = maxheap.peek() + minheap.peek();
            return ans /= 2.0;
        }else{
            return maxheap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */