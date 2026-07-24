class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int n = nums2.length;

        int[] nge = new int[n];
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() < nums2[i]){
                st.pop();
            }

            nge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }

        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < n; i++) mpp.put(nums2[i], i);

        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            int idx = mpp.get(nums1[i]);
            ans[i] = nge[idx];
        }

        return ans;
    }
}