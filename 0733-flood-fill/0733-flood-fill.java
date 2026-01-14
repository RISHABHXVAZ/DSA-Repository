class Solution {
    static void dfs(int[][] image, int sr, int sc, int inicolor, int color){
        if(sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0) return;
        if(image[sr][sc] != inicolor){
            return;
        }
        image[sr][sc] = color;
        dfs(image, sr+1, sc, inicolor, color);
        dfs(image, sr, sc+1, inicolor, color);
        dfs(image, sr-1, sc, inicolor, color);
        dfs(image, sr, sc-1, inicolor, color);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
     if(image[sr][sc] == color) return image;
     int inicolor = image[sr][sc];
     dfs(image, sr, sc, inicolor, color);
     return image;   
    }
}