class Solution {
    static int[] findnse(int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<Integer>();
        int ans[] = new int[n];
        for(int i = n-1;i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? n: st.peek();
            st.push(i);
        }
        return ans;
    }
    static int[] findpse(int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<Integer>();
        int ans[] = new int[n];
        for(int i = 0; i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1: st.peek();
            st.push(i);
        }
        return ans;
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int nse[] = findnse(arr);
        int pse[] = findpse(arr);
        int sum = 0;
        int mod = (int)(1e9 + 7);
        for(int i = 0; i < n; i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            long freq = left * right * 1L;

            // Contribution = frequency * value
            int val = (int)((freq * arr[i]) % mod);

            // Add contribution to sum
            sum = (sum + val) % mod;
        }
        return sum;
    }
}