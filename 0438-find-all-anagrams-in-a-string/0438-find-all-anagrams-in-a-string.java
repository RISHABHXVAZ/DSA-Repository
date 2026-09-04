class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();

        Map<Character, Integer> mpp = new HashMap<>();
        for(int i = 0; i < m; i++){
            char ch = p.charAt(i);
            mpp.put(ch, mpp.getOrDefault(ch, 0)+1);
        }

        int i = 0;
        int count = mpp.size();
        List<Integer> ans = new ArrayList<>();

        for(int j = 0; j < n; j++){
            char ch = s.charAt(j);

            if(mpp.containsKey(ch)){
                mpp.put(ch, mpp.get(ch)-1);
                if(mpp.get(ch) == 0) count--;
            }

            while(j-i+1 > m){
                char ch2 = s.charAt(i);
                if(mpp.containsKey(ch2)){
                    if(mpp.get(ch2) == 0) count++;
                    mpp.put(ch2, mpp.get(ch2)+1);
                }
                i++;
            }
            if(count == 0) ans.add(i);
        }

        return ans;
    }
}