class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        
        int a = 2, t = k;
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            if(nums[i] == t){
                t = a*k;
                a++;
            }
        }

        return t;
    }
}