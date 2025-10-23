class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<int[]>();
    }
    
    public int next(int price) {
        int ans = 1;
        while(!st.isEmpty() && price >= st.peek()[0]){
            ans += st.peek()[1];
            st.pop();
        }
        st.push(new int[]{price,ans});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */