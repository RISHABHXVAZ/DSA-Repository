class Solution {
    void func(int curr, int low, int high, List<Integer> ans){
        if(curr > high) return;
        if(curr >= low && curr <= high){
            ans.add(curr);
        }

        int lastdigit = curr%10;
        if(lastdigit == 9) return;
        func(curr*10 + (lastdigit+1), low, high, ans);
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i < 10; i++) func(i, low, high, ans);
        Collections.sort(ans);
        return ans;
    }
}