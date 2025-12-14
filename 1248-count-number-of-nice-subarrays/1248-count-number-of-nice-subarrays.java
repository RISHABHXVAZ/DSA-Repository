class Solution {
    static int func(int[] nums, int k){
        if(k < 0) return 0;
        int n = nums.length;
        int i = 0, j = 0;
        int cnt = 0, odd = 0;
        while(j < n){
           if(nums[j] % 2 == 1) odd++;
           while(odd > k){
            if(nums[i] % 2 == 1) odd--;
            i++;
           }
           cnt += (j-i+1);
           j++;
        }
        return cnt; 
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return func(nums, k) - func(nums, k-1);
    }
}