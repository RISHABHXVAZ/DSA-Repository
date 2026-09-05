class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        int maxarea = 0;
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                int h = heights[st.peek()];
                st.pop();
                int nse = i, pse = st.isEmpty() ? -1 : st.peek();

                maxarea = Math.max(maxarea, h * (nse-pse-1));
            }
            st.push(i);
        }
        
        while(!st.isEmpty()){
            int nse = n;
            int h = heights[st.pop()];
            int pse = st.isEmpty()? -1 : st.peek();
            maxarea = Math.max(maxarea, h*(nse-pse-1));
        }
        return maxarea;
    }
}