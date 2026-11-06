class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
        }

        int[] arr = new int[max+1];
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            mpp.put(nums[i], mpp.getOrDefault(nums[i],0)+1);
        }
        for(int k: mpp.keySet()){
            arr[k] = k*mpp.get(k);
        }

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for(int i = 2; i < arr.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
        }

        return dp[arr.length-1];
    }
}