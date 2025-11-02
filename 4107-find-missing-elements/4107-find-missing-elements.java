class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            if(nums[i] > largest){
                largest = nums[i];
            }
            if(nums[i] < smallest){
                smallest = nums[i];
            }
        }
        int hash[] = new int[largest+1];
        for(int i = 0; i < n; i++) hash[nums[i]] = 1;
        List<Integer> ans = new ArrayList<>();
        for(int i = smallest; i <= largest; i++){
            if(hash[i] == 0) ans.add(i);
        }
        return ans;
    }
}