class Solution {
    static int  maxAreaInHistogram(int[] nums){
        int n = nums.length;
        double maxArea = 0;
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < n ; i++){
           while (!st.isEmpty() && nums[st.peek()] >= nums[i]){
                int element = nums[st.pop()];
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, element * (nse - pse - 1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int element = nums[st.pop()];
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, element * (nse - pse - 1));
        }
        return (int)maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double maxArea = 0;

        // Create integer heights array
        int[][] heights = new int[rows][cols];
        for(int j = 0; j < cols; j++){
            heights[0][j] = Character.getNumericValue(matrix[0][j]);
        }

        for(int i = 1; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if (matrix[i][j] != '0') {
                    heights[i][j] = heights[i-1][j] + 1;
                } else {
                    heights[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < rows; i++){
            maxArea = Math.max(maxArea, maxAreaInHistogram(heights[i]));
        }
          return (int)maxArea;
    }
}
