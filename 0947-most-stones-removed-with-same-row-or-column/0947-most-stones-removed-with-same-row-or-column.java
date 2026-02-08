class Solution {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>(); 
    void initialize(int n){
        for(int i = 0; i < n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    int findParent(int u){
        if(u == parent.get(u)) return u;
        int ulp_u = findParent(parent.get(u));
        parent.set(u, ulp_u);
        return ulp_u;
    }
    void UnionBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v , size.get(ulp_u) + size.get(ulp_v));
        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
        return;
    }
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for(int i = 0; i < stones.length; i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        Map<Integer, Integer> mpp = new HashMap<>();
        int n = maxRow + maxCol + 2;
        initialize(n);
        for(int i = 0; i < stones.length; i++){
            int u = stones[i][0];
            int v = stones[i][1];
            UnionBySize(u, v+maxRow+1);
            mpp.put(u, 1);
            mpp.put(v+maxRow+1,1);
        }
        int comp = 0;
        for(int it: mpp.keySet()){
            if(findParent(it) == it) comp++;
        }
        return stones.length-comp;
        
    }
}