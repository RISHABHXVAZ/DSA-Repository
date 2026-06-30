class Solution {
    int[] size;
    int[] par;

    void initialise(int n){
        size = new int[n];
        par = new int[n];
        Arrays.fill(size, 1);
        for(int i = 0; i < n; i++) par[i] = i;
    }

    void Union(int u, int v){
        int upar = find(u);
        int vpar = find(v);
        if(upar == vpar) return;

        if(size[upar] <= size[vpar]){
            size[vpar] += size[upar];
            par[upar] = vpar;
        }
        else {
            size[upar] += size[vpar];
            par[vpar] = upar;
        }
    }

    int find(int x){
        if(x == par[x]) return x;
        par[x] = find(par[x]);
        return par[x];
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        initialise(n);

        Map<String, Integer> mpp = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);

                if(mpp.containsKey(mail)) Union(i, mpp.get(mail));
                else mpp.put(mail, i);
            }
        }

        List<List<String>> merged = new ArrayList<>();
        for(int i = 0; i < n; i++){
            merged.add(new ArrayList<>());
        }

        for(String mail : mpp.keySet()){
            int idx = find(mpp.get(mail));
            merged.get(idx).add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(merged.get(i).size() == 0) continue;

            Collections.sort(merged.get(i));

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(merged.get(i));

            ans.add(temp);
        }

        return ans;
    }
}