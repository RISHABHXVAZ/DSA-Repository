class Solution {
    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        int n = receiver.size();

        int LOG = (int)Math.floor(Math.log(k)/Math.log(2)) + 1;

        int[][] up = new int[n][LOG];
        long[][] sum = new long[n][LOG];

        for(int i = 0; i < n; i++){
            up[i][0] = receiver.get(i);
            sum[i][0] = receiver.get(i);
        }

        for(int j = 1; j < LOG; j++){
            for(int i = 0; i < n; i++){
                int midnode = up[i][j-1];
                up[i][j] = up[midnode][j-1];
                sum[i][j] = sum[i][j-1] + sum[midnode][j-1];
            }
        }
        long bestscore = 0;
        for(int i = 0; i < n; i++){
            int curr = i;
            long currscore = i;

            for(int j = 0; j < LOG; j++){
                if(((k >> j) & 1) == 1){
                    currscore += sum[curr][j];
                    curr = up[curr][j];
                }
            }

            bestscore = Math.max(bestscore, currscore);
        }

        return bestscore;

    }
}