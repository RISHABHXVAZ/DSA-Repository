class Solution {
    public int maximumSum(int[] nums) {
       int n = nums.length;
       List<Integer> l0 = new ArrayList<>();
       List<Integer> l1 = new ArrayList<>();
       List<Integer> l2 = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int mod = nums[i]%3;
            if(mod == 0) l0.add(nums[i]);
            else if(mod == 1) l1.add(nums[i]);
            else l2.add(nums[i]);
        }

        l0.sort(Collections.reverseOrder());
        l1.sort(Collections.reverseOrder());
        l2.sort(Collections.reverseOrder());

        int ans = 0;
        if(l0.size() >= 3) ans = Math.max(ans, l0.get(0) + l0.get(1) + l0.get(2));
        if(l1.size() >= 3) ans = Math.max(ans, l1.get(0) + l1.get(1) + l1.get(2));
        if(l2.size() >= 3) ans = Math.max(ans, l2.get(0) + l2.get(1) + l2.get(2));

        if(l0.size() >= 1 && l1.size() >=1 && l2.size() >= 1) ans = Math.max(ans, l0.get(0) + l1.get(0) + l2.get(0));

        return ans;

    }
}