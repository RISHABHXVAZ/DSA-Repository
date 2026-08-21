class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        int count = 0, el = -1;
        for(int i = 0; i < n; i++){
            if(count == 0){
                count = 1;
                el = nums[i];
            }else if(nums[i] == el){
                count++;
            }else count--;
        }

        return el;
    }
}