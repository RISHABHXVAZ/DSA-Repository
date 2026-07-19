class Solution {
    public boolean[] transformStr(String s, String[] strs) {
        int n = s.length();

        List<Integer> p = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0') p.add(i);
        }

        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            
            int fixed0 = 0;
            List<Integer> q = new ArrayList<>();

            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '0'){ 
                    fixed0++;
                    q.add(j);
                }
            }

            if(fixed0 > p.size()){
                ans.add(false);
                continue;
            }

            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '?' && q.size() < p.size()) q.add(j);
            }

            if(q.size() < p.size()){
                ans.add(false);
                continue;
            }

            Collections.sort(q);
            boolean flag = true;
            for(int j = 0; j < p.size(); j++){
                if(q.get(j) > p.get(j)){
                    flag = false;
                    break;
                }
            }

            ans.add(flag);
        }

        boolean res[] = new boolean[ans.size()];
        int k = 0;
        for(boolean x : ans) res[k++] = x;

        return res;
    }
}