class KthLargest {
    List<Integer> score;
    int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        score = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            score.add(nums[i]);
        }

        pq = new PriorityQueue<>();
        for(int num : score){
            if(pq.size() < k){
                pq.add(num);
                continue;
            }

            if(num > pq.peek()){
                pq.poll();
                pq.add(num);
            }
        }   

    }
    
    public int add(int val) {
        score.add(val);
        if(pq.size() < k){
            pq.add(val);
            return pq.peek();
        }

        if(val > pq.peek()){
            pq.poll();
            pq.add(val);
            return pq.peek();
        }

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */