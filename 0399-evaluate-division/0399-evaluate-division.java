class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> mpp = new HashMap<>();
        int idx = 0;
        for(int i = 0; i < equations.size(); i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            if(!mpp.containsKey(u)){
                mpp.put(u, idx++);
            }
            if(!mpp.containsKey(v)){
                mpp.put(v, idx++);
            }
        }

        double[][] cost = new double[26][26];
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                cost[i][j] = Double.MAX_VALUE;
            }
        }
        for(int i = 0; i < equations.size(); i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            cost[mpp.get(u)][mpp.get(u)] = 1;
            cost[mpp.get(v)][mpp.get(v)] = 1;
            cost[mpp.get(u)][mpp.get(v)] = values[i];
            cost[mpp.get(v)][mpp.get(u)] = 1.0/values[i];
        }

        for(int via = 0; via < 26; via++){
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < 26; j++){
                    if(cost[i][via] != Double.MAX_VALUE && cost[via][j] != Double.MAX_VALUE){
                        if(cost[i][j] == Double.MAX_VALUE) cost[i][j] = cost[i][via] * cost[via][j];
                    }
                }
            }
        }

        double[] ans = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);
            if(!mpp.containsKey(u) || !mpp.containsKey(v) || cost[mpp.get(u)][mpp.get(v)] == Double.MAX_VALUE) ans[i] = -1;
            else ans[i] = cost[mpp.get(u)][mpp.get(v)];
        }
        return ans;
    }
}