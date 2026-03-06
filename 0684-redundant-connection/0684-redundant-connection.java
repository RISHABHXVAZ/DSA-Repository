class Solution {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    void initialize(int n){
        for(int i = 0; i < n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    int findUPar(int u){
        if(u == parent.get(u)) return u;
        int par = findUPar(parent.get(u));
        parent.set(u, par);
        return par;
    }
    void UnionBySize(int u, int v){
        int upar = findUPar(u);
        int vpar = findUPar(v);
        if(upar == vpar) return;
        else if(size.get(upar) < size.get(vpar)){
            parent.set(upar, vpar);
            size.set(vpar, size.get(upar) + size.get(vpar));
        }else{
            parent.set(vpar, upar);
            size.set(upar, size.get(upar) + size.get(vpar));
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        initialize(n+1);
        Set<int[]> st = new HashSet<>();
        for(int i = 0; i < n; i++){
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            int v1par = findUPar(v1);
            int v2par = findUPar(v2);
            if(st.size() == n-1) break;
            if(v1par == v2par) continue;
            else{
                UnionBySize(v1, v2);
                st.add(edges[i]);
            }
        }
        int ans[] = new int[2];
        for(int i = 0; i < n; i++){
            if(!st.contains(edges[i])){
                ans = edges[i];
            }
        }
        return ans;
    }
}