class Solution {
    class Query {
        int l, r;
        int i;

        Query(int l, int r, int i) {
            this.l = l;
            this.r = r;
            this.i = i;
        }
    }

    long[] freq = new long[100005];
    int distinctCount = 0;
    int oddFreq = 0;

    void add(int i, int[] nums) {
        i = nums[i];
        if (freq[i] == 0) {
            distinctCount++;
        }
        freq[i]++;
        if (freq[i] % 2 == 1)
            oddFreq++;
        else
            oddFreq--;
    }

    void remove(int i, int[] nums) {
        i = nums[i];
        if (freq[i] % 2 == 1)
            oddFreq--;
        else
            oddFreq++;
        freq[i]--;
        if (freq[i] == 0)
            distinctCount--;

    }

    public boolean[] validSubarrays(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int blocks = (int) Math.ceil(Math.sqrt(n));

        Query[] Queries = new Query[m];

        for (int i = 0; i < m; i++) {
            Queries[i] = new Query(queries[i][0], queries[i][1], i);
        }

        int blocksize = Math.max(1, (int) Math.sqrt(n));

        Arrays.sort(Queries, (a, b) -> {
            int aLeftBlock = a.l / blocksize;
            int bLeftBlock = b.l / blocksize;
            if (aLeftBlock != bLeftBlock) {
                return Integer.compare(aLeftBlock, bLeftBlock);
            } else
                return Integer.compare(a.r, b.r);
        });

        boolean[] ans = new boolean[m];
        int currl = 0;
        int currr = -1;

        for (int i = 0; i < m; i++) {
            int targetL = Queries[i].l;
            int targetR = Queries[i].r;
            int idx = Queries[i].i;
            while (currr < targetR) {
                currr++;
                add(currr, nums);
            }

            while (currr > targetR) {
                remove(currr, nums);
                currr--;
            }

            while (currl < targetL) {
                remove(currl, nums);
                currl++;
            }

            while (currl > targetL) {
                currl--;
                add(currl, nums);
            }

            ans[idx] = distinctCount == k && oddFreq == 0;
        }

        return ans;
    }
}