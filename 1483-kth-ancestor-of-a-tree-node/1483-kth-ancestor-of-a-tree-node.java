class TreeAncestor {
    int[][] up;
    int LOG;

    public TreeAncestor(int n, int[] parent) {
        this.LOG = (int)Math.floor(Math.log(n) / Math.log(2)) + 1;
        up = new int[n][LOG];

        for (int i = 0; i < n; i++) {
            up[i][0] = parent[i];
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                int midnode = up[i][j - 1];
                if (midnode != -1) {
                    up[i][j] = up[midnode][j - 1];
                } else
                    up[i][j] = -1;

            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for(int j = 0; j < LOG; j++){
            if(((k >> j) & 1) == 1){
                node = up[node][j];
                if(node == -1) return -1;
            }
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */