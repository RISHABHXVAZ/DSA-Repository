class Solution {
    void addFactorsToMap(int n, Map<Integer, Integer> mpp){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                mpp.put(i, mpp.getOrDefault(i, 0)+1);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) {
            mpp.put(n, mpp.getOrDefault(n, 0) + 1);
        }
    }

    void removeFactorsFromMap(int n, Map<Integer,Integer> mpp){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                if(mpp.containsKey(i)){
                    mpp.put(i, mpp.get(i)-1);
                    if(mpp.get(i) == 0) mpp.remove(i);
                }

                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1 && mpp.containsKey(n)) {
            mpp.put(n, mpp.get(n) - 1);
            if (mpp.get(n) == 0) mpp.remove(n);
        }
        
    }
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        int i = 0;

        int ans = 0;
        for(int j = 0; j < n; j++){
            addFactorsToMap(nums[j], mpp);
            while(mpp.size() > k){
                removeFactorsFromMap(nums[i], mpp);
                i++;
            }

            ans = Math.max(ans, j-i+1);
        }

        return ans;
    }
}