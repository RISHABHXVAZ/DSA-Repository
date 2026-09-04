class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < m; i++){
            mpp.put(nums2[i], i);
        }

        Stack<Integer> st = new Stack<>();
        int[] nge = new int[m];
        for(int i = m-1; i >= 0; i--){
            
            while(!st.isEmpty() && st.peek() < nums2[i]){
                st.pop();
            }
            nge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }

        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = nge[mpp.get(nums1[i])];
        }
        return ans;
        }
}