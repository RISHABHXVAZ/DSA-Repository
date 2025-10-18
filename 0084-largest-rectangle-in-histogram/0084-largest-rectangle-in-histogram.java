class Solution {
    static int[] findnse(int nums[]){
        int n = nums.length;
        Stack<Integer> st = new Stack<Integer>();
        int ans[] = new int[n];
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    static int[] findpse(int nums[]){
        int n = nums.length;
        Stack<Integer> st = new Stack<Integer>();
        int ans[] = new int[n];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0;
        if(n == 1) return heights[0];

        int nse[] = findnse(heights);
        int pse[] = findpse(heights);
        double area = Double.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            int width = nse[i]-pse[i]-1;
            area = Math.max(area, width*heights[i]);
        }

        return (int)area;
    }
}