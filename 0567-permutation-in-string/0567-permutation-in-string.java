class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        Map<Character, Integer> mpp = new HashMap<>();
        for(int i = 0; i < m; i++){
            char ch = s1.charAt(i);
            mpp.put(ch, mpp.getOrDefault(ch,0)+1);
        }

        int count = mpp.size();
        int i = 0;
        for(int j = 0; j < n; j++){
            char ch = s2.charAt(j);

            if(mpp.containsKey(ch)){
                mpp.put(ch, mpp.getOrDefault(ch,0)-1);
                if(mpp.get(ch) == 0) count--;
            }

            while(j - i + 1 > m){
                char ch2 = s2.charAt(i);
                if(mpp.containsKey(ch2)){
                    if(mpp.get(ch2) == 0) count++;
                    mpp.put(ch2, mpp.get(ch2)+1);
                }
                i++;
            }

            if(count == 0) return true;
        }

        return false;
    }
}