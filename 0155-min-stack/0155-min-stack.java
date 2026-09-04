class MinStack {
    Stack<Long> st;
    long minValue;
    public MinStack() {
        st = new Stack<>();
        minValue = Long.MAX_VALUE;
    }
    
    public void push(int value) { 
          
        if(st.isEmpty()){
            st.push((long)value);
            minValue = (long)value;
        }else if(value >= minValue){
            st.push((long)value);
        }else{
            st.push(2L*value - minValue);
            minValue = (long)value;
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        long top = st.pop();
        if(top < minValue){
            minValue = 2*minValue - top;
        }

        if(st.isEmpty()) minValue = Long.MAX_VALUE;
    }
    
    public int top() {
        long top = st.peek();
        if(top >= minValue) return (int)top;
        else return (int)minValue;
    }
    
    public int getMin() {
        return (int) minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */