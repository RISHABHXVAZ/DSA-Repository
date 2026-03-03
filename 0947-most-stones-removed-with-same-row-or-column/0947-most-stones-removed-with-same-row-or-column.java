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
        else if(size.get(u) < size.get(v)){
            parent.set(upar, vpar);
            size.set(vpar, size.get(upar) + size.get(vpar));
        }else{
            parent.set(upar, vpar);
            size.set(upar, size.get(upar) + size.get(vpar));
        }
    } 
    public int removeStones(int[][] stones) {
        int maxrow = Integer.MIN_VALUE;
        int maxcol = Integer.MIN_VALUE;
        for(int i = 0; i < stones.length; i++){
            maxrow = Math.max(maxrow, stones[i][0]);
            maxcol = Math.max(maxcol, stones[i][1]);
        }
        
        int n = maxrow + maxcol + 2;
        initialize(n);
        
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < stones.length; i++){
            int u = stones[i][0];
            int v = stones[i][1];
            UnionBySize(u,v+maxrow+1);
            mpp.put(u,1);
            mpp.put(v + maxrow + 1, 1);
        }
        int comp = 0;
        for(int it: mpp.keySet()){
            if(parent.get(it) == it) comp++;
        }
        return stones.length - comp;
        
    }
}