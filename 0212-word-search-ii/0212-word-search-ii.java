class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
    void func(int r, int c, TrieNode root, char[][] board, List<String> ans, boolean[][] vis){
        int m = board.length;
        int n = board[0].length;

        if(root.word != null){
            ans.add(root.word);
            root.word = null;
        }

        vis[r][c] = true;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for(int i = 0; i < 4; i++){
            int nr = r + dx[i];
            int nc = c + dy[i];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc] && root.children[board[nr][nc]-'a'] != null){
                func(nr, nc, root.children[board[nr][nc]-'a'], board, ans, vis);
            }
        }
        vis[r][c] = false;
        return;
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
         int m = board.length;
        int n = board[0].length;

        for(String w : words){
            TrieNode node = root;
            for(char ch : w.toCharArray()){
                int i = ch-'a';
                if(node.children[i] == null){
                    node.children[i] = new TrieNode();
                }
                node = node.children[i];
            }
            node.word = w;
        }

        boolean[][] vis = new boolean[m][n];
        List<String> ans = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int idx = board[i][j] - 'a';
                if(root.children[idx] != null){
                    func(i, j, root.children[idx], board, ans, vis);
                }
            }
        }

        return ans;
    }
}