class Solution {
    void func(StringBuilder sb, String digits, int i, Map<Character, char[]> mpp, List<String> ans){
        if(i == digits.length()){
            ans.add(sb.toString());
            return;
        }
        char[] arr = mpp.get(digits.charAt(i));
        for(int j = 0; j < arr.length; j++){
            sb.append(arr[j]);
            func(sb, digits, i+1, mpp, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {

        int n = digits.length();

        Map<Character, char[]> mpp = new HashMap<>();
        mpp.put('2', new char[]{'a', 'b', 'c'});
        mpp.put('3', new char[]{'d', 'e', 'f'});
        mpp.put('4', new char[]{'g', 'h', 'i'});
        mpp.put('5', new char[]{'j', 'k', 'l'});
        mpp.put('6', new char[]{'m', 'n', 'o'});
        mpp.put('7', new char[]{'p', 'q', 'r', 's'});
        mpp.put('8', new char[]{'t', 'u', 'v'});
        mpp.put('9', new char[]{'w', 'x', 'y', 'z'});

        List<String> ans = new ArrayList<>();
        func(new StringBuilder(), digits, 0, mpp, ans);
        return ans;
    }
}