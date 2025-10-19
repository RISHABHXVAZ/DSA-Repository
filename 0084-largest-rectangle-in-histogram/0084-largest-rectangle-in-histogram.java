class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0;
        if(n == 1) return heights[0];
        Stack<Integer> st = new Stack<Integer>();
        double maxArea = Double.MIN_VALUE;
        for(int i = 0; i < n ; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int element = heights[st.peek()];
                st.pop();
                int nse = i, pse = st.isEmpty() ? -1: st.peek();
                maxArea = Math.max(maxArea, element*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int nse = n;
            int element = heights[st.peek()];
            st.pop();
            int pse = st.isEmpty() ? -1: st.peek();
            maxArea = Math.max(maxArea, element*(nse-pse-1));
        }

        return (int)maxArea;
    }
}