class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;


        int idx = -1;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                idx = i;
                break;
            }
        }

        boolean is_asc = true;
        for(int i = 0; i < n; i++){
            if(nums[(i+1) % n] != (nums[i]+1)%n){
                is_asc = false;
                break;
            }
        }

        if(is_asc) {
            return (int)Math.min(idx, (n - idx) % n + 2);
            }

        boolean is_des = true;
        for(int i = 0; i < n; i++){
            if(nums[(i+1) % n] != (nums[i]-1+n) % n){
                is_des = false;
                break;
            }
        }
        if(is_des){
            int op1 = ((idx+1)%n)+1;
            int op2 = n - idx;
            return (int)Math.min(op1, op2);
        }
        return -1;
    }
}