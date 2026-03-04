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
            size.set(vpar, size.get(vpar) + size.get(upar));
        }else{
            parent.set(vpar, upar);
            size.set(upar, size.get(upar) + size.get(vpar));
        }
    }

    boolean isValid(int adjr, int adjc, int n, int m){
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        initialize(n*m);
        int maxarea = Integer.MIN_VALUE;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    vis[i][j] = true;
                    int nodeno = i*m + j;
                    int dx[] = {1,-1,0,0};
                    int dy[] = {0,0,1,-1};
                    for(int k = 0; k < 4; k++){
                        int adjr = i + dx[k];
                        int adjc = j + dy[k];
                        if(isValid(adjr, adjc, n , m)){
                            int adjnode = adjr*m + adjc;
                            if(vis[adjr][adjc]){
                                if(findUPar(nodeno) != findUPar(adjnode)){
                                    UnionBySize(nodeno, adjnode);
                                }
                            }
                        }
                    }
                }
            }
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    int dx[] = {1,-1,0,0};
                    int dy[] = {0,0,1,-1};
                    Set<Integer> components = new HashSet<>();
                    for(int k = 0; k < 4; k++){
                        int adjr = i + dx[k];
                        int adjc = j + dy[k];
                        if(isValid(adjr, adjc, n, m)){
                            if(grid[adjr][adjc] == 1){
                                components.add(findUPar(adjr*m + adjc));
                            }
                        }
                    }
                    int totalsize = 0;
                    for(int it: components){
                        totalsize += size.get(it);
                    }
                    maxarea = Math.max(maxarea, totalsize+1);
                }
            }
        }
        for(int cellno = 0; cellno < n*m; cellno++){
            maxarea = Math.max(maxarea, size.get(findUPar(cellno)));
        }
        return maxarea;
    }
}