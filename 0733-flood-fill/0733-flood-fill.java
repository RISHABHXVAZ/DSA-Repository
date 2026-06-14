class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int org = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        q.add(new int[]{sr, sc});
        vis[sr][sc] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while(!q.isEmpty()){
            int[] p = q.poll();
            int x = p[0], y = p[1];

            image[x][y] = color;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && image[nx][ny] == org && !vis[nx][ny]){
                    vis[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }

        return image;
    }
}