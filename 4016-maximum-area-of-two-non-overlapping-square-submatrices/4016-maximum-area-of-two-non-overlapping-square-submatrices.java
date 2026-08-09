class Solution {
    boolean isValidSquare(int r1, int c1, int r2, int c2, int[][] mat, int[][] pref){
        int side = r2-r1+1;
        int top = r1 - 1 >= 0 ? pref[r1-1][c2] : 0;
        int left = c1 - 1 >= 0 ? pref[r2][c1-1] : 0;
        int topleft = r1-1 >= 0 && c1-1>=0? pref[r1-1][c1-1] : 0;

        int sum = pref[r2][c2] - top - left + topleft;
        return sum == side*side;
    }
    int area(int[][] mat, int[][] pref, int side){
        int n = mat.length;
        int m = mat[0].length;
        
        boolean[][] isValid = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int r2 = i, c2 = j;
                int r1 = i-side+1, c1 = j-side+1;
                if(r1 >= 0 && r1 < n && c1 >= 0 && c1 < m){
                    if(isValidSquare(r1, c1, r2, c2, mat, pref)){
                        isValid[i][j] = true;
                    }
                }
            }
        }

        boolean[] tophas = new boolean[n];
        for(int i = 0; i < n; i++){
            boolean found = false;
            if(i >= side - 1) {
                for(int j = 0; j < m; j++){
                    // Check if a valid square starts at row (i - side + 1)
                    if(i - side + 1 >= 0 && isValid[i - side + 1][j]) {
                        found = true;
                        break;
                    }
                }
            }
            tophas[i] = found || (i > 0 ? tophas[i - 1] : false);
        }

        boolean[] bottomhas = new boolean[n];
        for(int i = n - 1; i >= 0; i--){
            boolean found = false;
            for(int j = 0; j < m; j++){
                // Check if a valid square starts at row i
                if(isValid[i][j]){
                    found = true;
                    break;
                }
            }
            bottomhas[i] = found || (i < n - 1 ? bottomhas[i + 1] : false);
        }

        for(int i = 0; i < n - 1; i++){
            if(tophas[i] && bottomhas[i + 1]) return side * side;
        }
        
        // 2. Vertical Separation Check
        boolean[] lefthas = new boolean[m];
        for(int j = 0; j < m; j++){
            boolean found = false;
            if(j >= side - 1) {
                for(int i = 0; i < n; i++){
                    // Check if a valid square starts at col (j - side + 1)
                    if(j - side + 1 >= 0 && isValid[i][j - side + 1]){
                        found = true;
                        break;
                    }
                }
            }
            lefthas[j] = found || (j > 0 ? lefthas[j - 1] : false);
        }

        boolean[] righthas = new boolean[m];
        for(int j = m - 1; j >= 0; j--){
            boolean found = false;
            for(int i = 0; i < n; i++){
                // Check if a valid square starts at col j
                if(isValid[i][j]){
                    found = true;
                    break;
                }
            }
            righthas[j] = found || (j < m - 1 ? righthas[j + 1] : false);
        }

        for(int j = 0; j < m - 1; j++){
            if(lefthas[j] && righthas[j + 1]) return side * side;
        }

        return -1;
    }
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] pref = new int[n][m];
        pref[0][0] = mat[0][0];
        for(int i = 1; i < n; i++){
            pref[i][0] = pref[i-1][0] + mat[i][0];
        }

        for(int j = 1; j < m; j++){
            pref[0][j] = pref[0][j-1] + mat[0][j];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                pref[i][j] = pref[i][j-1] + pref[i-1][j] - pref[i-1][j-1] + mat[i][j];
            }
        }

        int low = 1, high = Math.min(m, n);
        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            int x = area(mat, pref, mid);
            if(x != -1){
                ans = x;
                low = mid+1;
            }else high = mid-1;
        }

        return ans;
    }
}