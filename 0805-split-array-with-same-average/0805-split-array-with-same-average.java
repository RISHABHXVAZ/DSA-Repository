class Solution {
    void generateSubsets(int start, int end, int curr, int count, List<Integer>[] ans, int[] nums){
        if(start == end){
            ans[count].add(curr);
            return;
        }

        generateSubsets(start+1, end, curr+nums[start], count+1, ans, nums);
        generateSubsets(start+1, end, curr, count, ans, nums);
    }
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int total = 0;
        int mid = n/2;

        for(int num : nums) total += num;
        int[] transformed = new int[n];
        for (int i = 0; i < n; i++) {
            transformed[i] = nums[i] * n - total;
        }

        double avg = total/(double)n;

        List<Integer>[] left = new List[mid+1];
        List<Integer>[] right = new List[n-mid+1];

        for (int i = 0; i < left.length; i++) {
    left[i] = new ArrayList<>();
}

for (int i = 0; i < right.length; i++) {
    right[i] = new ArrayList<>();
}

        generateSubsets(0, mid, 0, 0, left, transformed);
        generateSubsets(mid, n, 0, 0, right, transformed);

        for(int i = 0; i < right.length; i++){
            Collections.sort(right[i]);
        }

        for(int la = 0; la < left.length; la++){
            for(int lb = 0; lb < right.length; lb++){
                if(la + lb == 0 || la+lb == n) continue;
                List<Integer> lsum = left[la];
                List<Integer> rsum = right[lb];

                for(int a : lsum){
                    int target = -a;
                    int idx = Collections.binarySearch(rsum, target);

                    if(idx >= 0) return true;
                }
            }
        }

        return false;

    }
}