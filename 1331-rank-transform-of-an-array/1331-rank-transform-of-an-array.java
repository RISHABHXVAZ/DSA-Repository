class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        int rank = 1;
        for(int i = 0; i < n; i++){
            temp[i] = arr[i];
        }

        Arrays.sort(temp);
        Map<Integer, Integer> mpp = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(!mpp.containsKey(temp[i])){
                mpp.put(temp[i], rank++);
            }
        }

        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = mpp.get(arr[i]);
        }

        return ans;
    }
}