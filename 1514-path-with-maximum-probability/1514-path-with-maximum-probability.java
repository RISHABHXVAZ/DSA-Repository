class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] prob = new double[n];
        Arrays.fill(prob, Double.MIN_VALUE);
        List<List<double[]>> adj = new ArrayList<>();
        for(int i = 0; i < n ;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];
            adj.get(u).add(new double[]{v,p});
            adj.get(v).add(new double[]{u,p});
        }
        prob[start_node] = 1;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0],a[0]));
        pq.add(new double[]{1,start_node});
        while(!pq.isEmpty()){
            double pr = pq.peek()[0];
            int node = (int)pq.peek()[1];
            pq.remove();
            for(double[] it: adj.get(node)){
                if(it[1]*pr > prob[(int)it[0]]){
                    prob[(int)it[0]] = it[1]*pr;
                    pq.add(new double[]{prob[(int)it[0]], it[0]});
                }
            }
        }
        return prob[end_node] == Double.MIN_VALUE ? 0 : prob[end_node];
    }
}