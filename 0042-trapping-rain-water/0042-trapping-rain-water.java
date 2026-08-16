class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        prefix[0] = height[0];

        for(int i = 1; i < n; i++){
            if(height[i] > prefix[i-1]){
                prefix[i] = height[i];
            }else prefix[i] = prefix[i-1];
        }

        int[] suff = new int[n];
        suff[n-1] = height[n-1];

        for(int j = n-2; j >= 0; j--){
            if(height[j] > suff[j+1]){
                suff[j] = height[j];
            }else suff[j] = suff[j+1];
        }

        int total = 0;

        for(int i = 0; i < n; i++){
            total += Math.min(prefix[i], suff[i]) - height[i];
        }

        return total;
    }
}