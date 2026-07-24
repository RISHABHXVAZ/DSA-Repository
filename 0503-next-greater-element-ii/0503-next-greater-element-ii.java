class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = nums[i % n];
        }

        int[] nge = new int[2*n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }

        int[] ans = new int[n];
        for(int i = 0; i < n; i++) ans[i] = nge[i];

        return ans;
    }
}