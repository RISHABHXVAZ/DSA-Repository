class Solution {
    static int[] findnse(int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<Integer>();
        int ans[] = new int[arr.length];
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    static int[] findpse(int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<Integer>();
        int ans[] = new int[arr.length];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1: st.peek();
            st.push(i);
        }
        return ans;
    }
    static int[] findnge(int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<Integer>();
        int ans[] = new int[arr.length];
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    static int[] findpge(int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<Integer>();
        int ans[] = new int[arr.length];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1: st.peek();
            st.push(i);
        }
        return ans;
}
    public long subArrayRanges(int[] nums) {
        int[] nse = findnse(nums);
        int[] pse = findpse(nums);
        int[] nge = findnge(nums);
        int[] pge = findpge(nums);
        
        int n = nums.length;
        long sum1 = 0, sum2 = 0;
        for(int i = 0; i < n ; i++){
            long left1 = i - pse[i];
            long right1 = nse[i] - i;

            long left2 = i - pge[i];
            long right2 = nge[i] - i;

            sum1 += (left1*right1*1L*nums[i]);
            sum2 += (left2*right2*1L*nums[i]);
        }
        return sum2 - sum1;
    }
}