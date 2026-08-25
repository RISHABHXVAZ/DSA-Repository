class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();

        int[] count = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        if(s.charAt(0) == '*'){
            count[0] = 1;
            left[0] = -1;
        }
        for(int i = 1; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                count[i] = count[i-1] + 1;
                left[i] = left[i-1];
            }else{
                count[i] = count[i-1];
                left[i] = i;
            }
        }

        if(s.charAt(n-1) == '|') right[n-1] = n-1;
        else right[n-1] = -1;

        for(int i = n-2; i >= 0; i--){
            char ch = s.charAt(i);
            if(ch == '|'){
                right[i] = i;
            }else{
                right[i] = right[i+1];
            }
        }

        int m = queries.length;
        int[] ans = new int[m];

        for(int i = 0; i < m; i++){
            int l = queries[i][0];
            int r = queries[i][1];

            int c1 = right[l];
            int c2 = left[r];

            if(c1 != -1 && c2 != -1 && c1 < c2){
                ans[i] = count[c2] - count[c1];
            }
        }

        return ans;
    }
}