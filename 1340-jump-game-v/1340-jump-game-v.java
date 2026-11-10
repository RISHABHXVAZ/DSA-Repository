class Solution {
    int func(int i, int d, int[] nge, int[] pge, int[] arr, int[] dp){
        if(i == nge.length || i == -1) return 0;
        if(dp[i] != -1) return dp[i];

        int op1 = 0;
        for(int j = i+1; j < nge[i] && j-i <= d; j++){
            if(arr[j] >= arr[i]) continue;
            op1 = Math.max(op1, 1 + func(j, d, nge, pge, arr, dp));
        }

        int op2 = 0;
        for(int j = i-1; j > pge[i] && i-j <= d; j--){
            if(arr[j] >= arr[i]) continue;
            op2 = Math.max(op2, 1 + func(j, d, nge, pge, arr, dp));
        }

        return dp[i] = (int)Math.max(op1, op2);
    }
    void calculate(int[] nge, int[] pge, int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        
        //nge
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st = new Stack<>();

        //pge
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] nge = new int[n];
        int[] pge = new int[n];
        calculate(nge, pge,  arr);

        int ans = Integer.MIN_VALUE;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for(int i = 0; i < n; i++){
            int indicesVisited = 1 + func(i,d,nge,pge,arr,dp); 
            ans = Math.max(ans, indicesVisited);
        }

        return ans;
    }
}