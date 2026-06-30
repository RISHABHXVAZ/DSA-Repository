class Solution {
    int[] size;
    int[] par;

    void initialise(int n){
        size = new int[n];
        par = new int[n];

        Arrays.fill(size, 1);
        for(int i = 0; i < n; i++){
            par[i] = i;
        }
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

    int find(int x){
        if(x == par[x]) return x;
        par[x] = find(par[x]);
        return par[x];
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        initialise(n*n);

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        boolean[] vis = new boolean[n*n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) continue;
                for(int k = 0; k < 4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 1){
                        Union(i*n+j, nx*n+ny);
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    int sum = 0;
                    for(int k = 0; k < 4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 1){
                            int upar = find(nx*n+ny);
                            if(vis[upar]) continue;
                            vis[upar] = true;
                            sum += size[upar];
                        }
                    }
                    ans = Math.max(ans, sum+1);

                    for(int k = 0; k < 4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                            int upar = find(nx*n+ny);
                            vis[upar] = false;
                        }
                    }
                }
           }
        }

        return ans == Integer.MIN_VALUE ? n*n : ans;

    }
}