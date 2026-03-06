class Solution {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    void initialize(int n){
        for(int i = 0; i < n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    int findUpar(int u){
        if(u == parent.get(u)) return u;
        int par = findUpar(parent.get(u));
        parent.set(u, par);
        return par;
    }

    void UnionBySize(int u, int v){
        int upar = findUpar(u);
        int vpar = findUpar(v);
        if(upar == vpar) return;
        else if(size.get(upar) < size.get(vpar)){
            parent.set(upar,vpar);
            size.set(vpar, size.get(upar) + size.get(vpar));
        }else{
            parent.set(vpar, upar);
            size.set(upar, size.get(vpar) + size.get(upar));
        }
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        initialize(n);
        for(List<Integer> pair: pairs){
            int u = pair.get(0);
            int v = pair.get(1);
            UnionBySize(u,v);
        }
        Map<Integer, List<Integer>> mpp = new HashMap<>();
        for(int i = 0; i < n; i++){
            int par = findUpar(i);
            if(!mpp.containsKey(par)){
                mpp.put(par, new ArrayList<>());
                mpp.get(par).add(i);
            }else{
            mpp.get(par).add(i);
            }
        }

        char[] res = new char[n];

        for(List<Integer> lst : mpp.values()){

            List<Character> chars = new ArrayList<>();

            for(int idx : lst){
                chars.add(s.charAt(idx));
            }

            Collections.sort(lst);
            Collections.sort(chars);

            for(int i = 0; i < lst.size(); i++){
                res[lst.get(i)] = chars.get(i);
            }
        }
         return new String(res);
    }
}