class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int[][] litterId = new int[m][n];
        int si = -1, sj = -1, litters = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char cell = classroom[i].charAt(j);
                if(cell == 'S'){
                    si = i;
                    sj = j;
                }else if(cell == 'L'){
                    litterId[i][j] = litters++;
                }
            }
        }

        int targetMask = (1 << litters) - 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{si, sj, energy, 0, 0});
        boolean[][][][] vis = new boolean[m][n][energy+1][1 << litters];

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while(!q.isEmpty()){
            int[] p = q.poll();
            int r = p[0], c = p[1], e = p[2], moves = p[3], mask = p[4];

            if(mask == targetMask) return moves;
            if(e == 0) continue;

            for(int i = 0; i < 4; i++){
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    char cell = classroom[nr].charAt(nc);
                    if(cell == 'X') continue;
                    int nextEnergy = e-1;
                    int nextMask = mask;
                    if(cell == 'R'){
                        nextEnergy = energy;
                    }else if(cell == 'L'){
                        nextMask |= (1 << litterId[nr][nc]);
                    }

                    if(!vis[nr][nc][nextEnergy][nextMask]){
                        vis[nr][nc][nextEnergy][nextMask] = true;
                        q.add(new int[]{nr, nc, nextEnergy, moves+1, nextMask});
                    }
                }
            }
        }

        return -1;
    }
}