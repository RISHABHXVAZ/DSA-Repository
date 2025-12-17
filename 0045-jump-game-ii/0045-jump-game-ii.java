class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        int jumps = 0;
        while(r < n-1){
            int farthest = 0;
            for(int i = l; i <= r; i++){
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;                  //[2 , 3 , 1 , 1 , 4]
            r = farthest;               //     l   r
            jumps++;
        }
        return jumps;
    }
}