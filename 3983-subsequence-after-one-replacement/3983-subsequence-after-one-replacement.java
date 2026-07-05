class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] left = new int[n];
        Arrays.fill(left, -1);

        int j = 0;
        for(int i = 0; i < n; i++){
            while(j < m && t.charAt(j) != s.charAt(i)){
                j++;
            }

            if(j < m){
                left[i] = j;
                j++;
            }else break;
        }

        if(left[n-1] != -1) return true;

        int[] right = new int[n];
        Arrays.fill(right, m);

         j = m-1;
        for(int i = n-1; i >= 0; i--){
            while(j >= 0 && t.charAt(j) != s.charAt(i)){
                j--;
            }

            if(j >= 0){
                right[i] = j;
                j--;
            }else break;
        }

        int lidx = -1, ridx = n;
        for(int i = 0; i < n; i++){
            if(left[i] == -1){
                lidx = i;
                break;
            }
        }

        for(int i = n-1; i >= 0; i--){
            if(right[i] == -1){
                ridx = i;
                break;
            }
        }

        for(int i = 0; i < n; i++){
            int l = i > 0 ? left[i-1] : -1;
            int r = i < n-1 ? right[i+1] : m;

            if(l != -1 || i == 0){
                if(r != m || i == n-1){
                    if(r - l > 1) return true;
                }
            } 
        }

        return false;
        
    }
}