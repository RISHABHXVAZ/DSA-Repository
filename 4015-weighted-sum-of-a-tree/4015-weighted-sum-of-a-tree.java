class Solution {
    long getDepth(int i, int[] parent, long[] depth){
        if(i == -1) return 0;
        if(depth[i] > 0) return depth[i];

        depth[i] = getDepth(parent[i], parent, depth)+1;
        return depth[i];
    }
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;
        long[] depth = new long[n];
        depth[0] = 1;
        long height = 1;
        for(int i = 1; i < n; i++){
            height = Math.max(height, getDepth(i, parent, depth));
        }

        long sum = 0;
        for(int i = 0; i < n; i++){
            sum += (long)nums[i]*(height-depth[i]+1);
        }

        return sum;
    }
}