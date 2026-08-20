class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        if(st.isEmpty()){
            st.add(new int[]{price, 1});
            return 1;
        }

        int count = 1;
        while(!st.isEmpty() && st.peek()[0] <= price){
            count += st.peek()[1];
            st.pop();
        }
        st.add(new int[]{price, count});
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */