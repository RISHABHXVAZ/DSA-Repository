class Solution {
    public int minOperations(String s) {
        int n = s.length();

        int total = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int ans = 0;
            for(int j = 0; j < n/2; j++){
                char c1 = s.charAt(j);
                char c2 = s.charAt(n-j-1);

                int val1 = c1-'a';
                int val2 = c2-'a';

                int cost1 = (val1-val2+26)%26;
                int cost2 = (val2-val1+26)%26;

                ans += Math.min(cost1, cost2);
            }

            total = Math.min(ans+i, total);
            s = s.substring(1) + s.substring(0, 1);
        }

        return total;
    }
}