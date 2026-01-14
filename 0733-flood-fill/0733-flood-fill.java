class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        if(image[sr][sc] == color) return image;
        image[sr][sc] = color;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){
            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,1,-1};
                int[] point = q.poll();
                for(int j = 0; j < 4; j++){
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];
                    if(x >= 0 && x < image.length && y >= 0 && y < image[0].length){
                        if(image[x][y] == iniColor){
                            image[x][y] = color;
                            q.add(new int[]{x,y});
                        }
                    }
                }
            }
        return image;
    }
}