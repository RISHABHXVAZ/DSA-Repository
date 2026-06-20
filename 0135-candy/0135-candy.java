class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] help = new int[n];
        Arrays.fill(help, 1);

        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]) help[i] = help[i-1]+1;
        }

        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1] && help[i] <= help[i+1]) help[i] = help[i+1]+1;
        }

        int ans = 0;
        for(int i : help) ans += i;
        return ans;
    }
}