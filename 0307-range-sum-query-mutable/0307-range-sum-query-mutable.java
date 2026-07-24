class NumArray {
    class FenwickTree{
        int[] tree;
        int size;

        FenwickTree(int size){
            this.tree = new int[size+1];
            this.size = size;
        }

        void add(int val, int i){
            while(i <= size){
                tree[i] += val;
                i += (i & -i);
            }
        }

        int query(int i){
            int sum = 0;
            while(i > 0){
                sum += tree[i];
                i -= (i & -i);
            }

            return sum;
        }
    }
    FenwickTree bit;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        bit = new FenwickTree(n);

        for(int i = 1; i <= n; i++){
            bit.add(nums[i-1], i);
        }
        // for(int i = 0; i < n; i++){
        //     bit.tree[i+1] = nums[i];
        // }

        // for(int i = 1; i <= bit.size; i++){
        //     int parent = i + (i & -i);
        //     if(parent <= bit.size) {
        //         bit.tree[parent] += bit.tree[i];
        //     }
        // }
    }
    
    public void update(int index, int val) {
        bit.add(val-nums[index], index+1);
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        return bit.query(right+1) - bit.query(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */