class Solution {
    int[] size;
    int[] par;

    void initialise(int n){
        size = new int[n];
        Arrays.fill(size, 1);
        
        par = new int[n];
        for(int i = 0; i < n; i++) par[i] = i;
    }

    void union(int u, int v){
        int upar = find(u);
        int vpar = find(v);
        if(upar == vpar) return;

        if(size[upar] <= size[vpar]){
            size[vpar] += size[upar];
            par[upar] = vpar;
        }else{
            size[upar] += size[vpar];
            par[vpar] = upar;
        }
    }

    int find(int x){
        if(x == par[x]) return x;
        par[x] = find(par[x]);
        return par[x];
    }
    int getDist(int[] p1, int[] p2){
        int x1 = p1[0], x2 = p2[0];
        int y1 = p1[1], y2 = p2[1];

        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        initialise(n);
        List<int[]> edges = new ArrayList<>();

        int k = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int x = getDist(points[i], points[j]);
                edges.add(new int[]{i, j, x});
            }
        }

        Collections.sort(edges, (a,b) -> a[2]-b[2]);
        int count = 0, sum = 0;

        for(int[] edge: edges){
            int upar = find(edge[0]);
            int vpar = find(edge[1]);
            if(upar == vpar) continue;
            if(count == n-1) break;

            union(edge[0], edge[1]);
            sum += edge[2];
        }
        
        return sum;
    }
}