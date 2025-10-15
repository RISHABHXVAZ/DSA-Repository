class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lmax,rmax,l,r,total;
        lmax = rmax = l = total = 0;
        r = n-1;

        while(l < r){
            if(height[l] <= height[r]){
                if(lmax > height[l]) total += lmax - height[l];
                else lmax = height[l];
                l++;
            }
            else{
                if(rmax > height[r]) total += rmax - height[r];
                else rmax = height[r];
                r--;
            }
        }

        return total;
    }
}