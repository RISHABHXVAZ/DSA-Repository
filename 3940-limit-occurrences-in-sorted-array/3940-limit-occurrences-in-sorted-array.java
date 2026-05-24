class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        List<Integer> lst = new ArrayList<>();

        for(int j = 0; j < n; j++){
            if(nums[i] == nums[j]) continue;

            int occ = j-i <= k ? j-i : k;

            for(int a = 0; a < occ; a++){
                lst.add(nums[i]);
            }

            i = j;
        }
        while(i < n && k != 0){
            lst.add(nums[i]);
            i++;k--;
        }

        int[] ans = new int[lst.size()];
        for(int x = 0; x < lst.size(); x++){
            ans[x] = lst.get(x);
        }
        return ans;
    }
}