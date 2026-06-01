class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        if(n == 1) return cost[0];
        Arrays.sort(cost);
        int total = 0;
        int i = n-1, j = n-2;
        while(i >= 0 && j >= 0){
            total += cost[i]+cost[j];
            i -= 3;
            j -= 3;
        }

        while(i >= 0){
            total += cost[i];
            i--;
        }
        return total;
    }
}