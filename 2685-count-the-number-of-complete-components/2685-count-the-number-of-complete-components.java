class Solution {
    int[] size;
    int[] par;
    int[] edgeCount;

    void initialise(int n){
        size = new int[n];
        Arrays.fill(size, 1);
        par = new int[n];
        for(int i = 0; i < n; i++) par[i] = i;

        edgeCount = new int[n];
    }

    void Union(int u, int v){
        int upar = find(u);
        int vpar = find(v);
        if(upar == vpar) {
            edgeCount[upar]++;
            return;
        }
        else if(size[upar] <= size[vpar]){
            size[vpar] += size[upar];
            edgeCount[vpar] += edgeCount[upar]+1;
            par[upar] = vpar;
        }else{
            size[upar] += size[vpar];
            edgeCount[upar] += edgeCount[vpar]+1;
            par[vpar] = upar;
        }
    }

    int find(int u){
        if(u == par[u]) return u;
        par[u] = find(par[u]);
        return par[u];
    }
    public int countCompleteComponents(int n, int[][] edges) {
        initialise(n);

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            Union(u, v);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            if(par[i] == i){
                int m = size[i];
                int e = edgeCount[i];
                if(e == m*(m-1)/2) ans++;
            }
        }

        return ans;
    }
}