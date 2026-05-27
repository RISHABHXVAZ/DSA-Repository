class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        List<Integer> temp = new ArrayList<>();
        int size = 0;

        for(int x: nums){
            int left = 0;
            int right = size;

            while(left < right){
                int mid = left + (right-left)/2;

                if(temp.get(mid) < x){
                    left = mid+1;
                }else right = mid;
            }

            if(left == size){
                temp.add(x);
                size++;
            }else temp.set(left, x);
        }
        return size;
    }
}