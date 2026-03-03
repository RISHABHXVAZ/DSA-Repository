class Solution {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    void initialize(int n){
        for(int i = 0; i < n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    int findUPar(int u){
        if(u == parent.get(u)) return u;
        int par = findUPar(parent.get(u));
        parent.set(u, par);
        return par;
    }

    void UnionBySize(int u, int v){
        int upar = findUPar(u);
        int vpar = findUPar(v);

        if(upar == vpar) return;

        if(size.get(upar) < size.get(vpar)){
            parent.set(upar, vpar);
            size.set(vpar, size.get(upar) + size.get(vpar));
        }else{
            parent.set(vpar, upar);
            size.set(upar, size.get(upar) + size.get(vpar));
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        initialize(n);

        Map<String, Integer> mpp = new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);

                if(mpp.containsKey(mail)){
                    UnionBySize(i, mpp.get(mail));
                }else{
                    mpp.put(mail, i);   // FIXED
                }
            }
        }

        // 🔥 Create list to store emails of each parent
        List<List<String>> merged = new ArrayList<>();
        for(int i = 0; i < n; i++){
            merged.add(new ArrayList<>());
        }

        for(String mail : mpp.keySet()){
            int parentIndex = findUPar(mpp.get(mail));
            merged.get(parentIndex).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(merged.get(i).size() == 0) continue;

            Collections.sort(merged.get(i));   // FIXED sorting

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));  // name
            temp.addAll(merged.get(i));

            ans.add(temp);
        }

        return ans;
    }
}