class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int nchild = g.length;
        int ncookies = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0, r = 0;
        while(l < nchild && r < ncookies){
            if(s[r] >= g[l]){
                l++;
            }
            r++;
        }
        return l;
    }
}