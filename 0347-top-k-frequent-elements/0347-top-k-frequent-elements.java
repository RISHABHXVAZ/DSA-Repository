class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();

        for(int i = 0; i < n; i++){
            mpp.put(nums[i], mpp.getOrDefault(nums[i],0)+1);
        }

        int[][] arr = new int[mpp.size()][2];

        int l = 0;
        for(int it: mpp.keySet()){
            arr[l][0] = it;
            arr[l][1] = mpp.get(it);
            l++;
        }

        Arrays.sort(arr, (a,b) -> b[1]-a[1]);
        int[] ans = new int[k];

        for(int i = 0; i < k; i++){
            ans[i] = arr[i][0];
        }

        return ans;
    }
}