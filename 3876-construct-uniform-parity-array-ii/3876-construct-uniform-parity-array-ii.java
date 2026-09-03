class Solution {
    public boolean uniformArray(int[] nums) {
        int n = nums.length;
        
        //check all even
        boolean even = true;
        for(int i = 0; i < n; i++){
            if(nums[i] % 2 == 1){
                even = false;
                break;
            }
        }

        boolean odd = true;
        for(int i = 0; i < n; i++){
            if(nums[i] % 2 == 0){
                odd = false;
                break;
            }
        }

        if(even || odd) return true;

        int smallest = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            smallest = Math.min(smallest, nums[i]);
        }

        return smallest % 2 == 1;
    }
}