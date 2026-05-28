class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        for(int i = 0; i < n; i++) hash[i] = i;

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if((nums[prev] % nums[i] == 0 || nums[i] % nums[prev] == 0) && dp[prev]+1 > dp[i]){
                    dp[i] = 1 + dp[i];
                    hash[i] = prev;
                }
            }
        }

        int maxval = Integer.MIN_VALUE;
        int maxidx = -1;
        for(int i = 0; i < n; i++){
            if(dp[i] > maxval){
                maxval = dp[i];
                maxidx = i;
            }
        }

        int i = maxidx;
        while(hash[i] != i){
            ans.add(nums[i]);
            i = hash[i];
        }

        ans.add(nums[i]);
        Collections.reverse(ans);
        return ans;
    }
}