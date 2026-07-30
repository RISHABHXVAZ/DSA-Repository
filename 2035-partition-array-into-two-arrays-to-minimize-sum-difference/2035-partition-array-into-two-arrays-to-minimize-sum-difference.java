class Solution {
    void generatesubsets(int start, int end, int curr, int count, List<Integer>[] ans, int[] nums){
        if(start == end){
            ans[count].add(curr);
            return;
        }

        generatesubsets(start+1, end, curr+nums[start], count+1, ans, nums);
        generatesubsets(start+1, end, curr, count, ans, nums);
    }
    public int minimumDifference(int[] nums) {
        int l = nums.length;
        int n = l/2;

        int total = 0;
        for(int num: nums) total += num;

        List<Integer>[] leftsum = new List[n+1];
        List<Integer>[] rightsum = new List[n+1];

        for(int i = 0; i <= n ; i++){ 
            leftsum[i] = new ArrayList<>();
            rightsum[i] = new ArrayList<>();
        }
        generatesubsets(0, n, 0, 0, leftsum, nums);
        generatesubsets(n, l, 0, 0, rightsum, nums);

        for(int i = 0; i < n; i++){
            Collections.sort(rightsum[i]);
        }

        int ans = Integer.MAX_VALUE;
        for(int k = 0; k <= n; k++){
            int fromright = n-k;
            List<Integer> left = leftsum[k];
            List<Integer> right = rightsum[fromright];

            for(int lefts : left){
                int target = total/2 - lefts;

                int idx = Collections.binarySearch(right, target);
                if(idx >= 0){
                    int b = right.get(idx);
                    return Math.abs(2*(lefts+b) - total);
                }

                int insertion = -idx-1;
                if(insertion < right.size()){
                    ans = Math.min(ans, Math.abs(2*(lefts+right.get(insertion)) - total));
                }
                if(insertion > 0) ans = Math.min(ans, Math.abs(2*(lefts + right.get(insertion-1)) - total));

            }
        }
        return ans;
    }
}