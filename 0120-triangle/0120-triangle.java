class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(triangle.size()-1).size();

        int[] front = new int[n];
        for(int i = 0; i < n; i++) front[i] = triangle.get(m-1).get(i);

        for(int i = m-2; i >= 0; i--){
            int[] curr = new int[triangle.get(i).size()];
            for(int j = 0; j < curr.length; j++){
                curr[j] = triangle.get(i).get(j) + Math.min(front[j], front[j+1]);
            }
            front = curr;
        }

        return front[0];
    }
}