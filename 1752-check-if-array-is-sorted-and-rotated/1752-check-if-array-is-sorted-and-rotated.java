class Solution {
    void reverse(int[] temp, int i, int j){
        while(i < j){
            int t = temp[i];
            temp[i] = temp[j];
            temp[j] = t;
            i++;
            j--;
        }

        return;
    }
    void rotate(int[] temp, int d){
        reverse(temp, 0, d-1);
        reverse(temp, d, temp.length-1);
        reverse(temp, 0, temp.length-1);
    }
    public boolean check(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        for(int i = 0; i < n; i++){
            temp[i] = nums[i];
        }

        Arrays.sort(temp);

        for(int i = 0; i < n; i++){
            rotate(temp, 1);
            int flag = 0;
            for(int j = 0; j < n; j++){
                if(temp[j] != nums[j]){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) return true;
        }

        return false;
    }
}