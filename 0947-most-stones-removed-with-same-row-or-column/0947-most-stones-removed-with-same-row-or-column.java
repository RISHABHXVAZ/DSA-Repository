class Solution {
    int[] size;
    int[] par;

    void initialise(int n){
        size = new int[n];
        par = new int[n];

        Arrays.fill(size, 1);
        for(int i = 0; i < n; i++) par[i] = i;
    }

    int find(int x){
        if(x == par[x]) return x;
        par[x] = find(par[x]);
        return par[x];
    }

    void Union(int u, int v){
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
    public int removeStones(int[][] stones) {
        int n = stones.length;
        initialise(n);

        for(int i = 0; i < n; i++){
            int[] p1 = stones[i];
            for(int j = i+1; j < n; j++){
                int[] p2 = stones[j];
                if(p1[0] == p2[0] || p1[1] == p2[1]){
                    Union(i, j);
                }
            }
        }

        Set<Integer> st = new HashSet<>();
        for(int i = 0; i < n; i++){
            st.add(find(i));
        }
        return n - st.size();
    }
}