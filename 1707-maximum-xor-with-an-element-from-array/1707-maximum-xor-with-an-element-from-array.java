class Node{
    Node links[] = new Node[2];

    boolean containsKey(int bit){
        return links[bit] != null;
    }

    void put(int bit, Node node){
        links[bit] = node;
    }

    Node get(int bit){
        return links[bit];
    }
}

class Trie{
    Node root;

    Trie(){
        root = new Node();
    }

    void insert(int num){
        Node node = root;
        for(int i = 31; i >= 0; i--){
            int b = (num >> i) & 1;

            if(!node.containsKey(b)){
                node.put(b, new Node());
            }

            node = node.get(b);
        }
    }

    int getMaxXor(int num){
        Node node = root;
        int xor = 0;
        for(int i = 31; i >= 0; i--){
            int b = (num >> i) & 1;
            if(node.containsKey(1-b)){
                xor = xor | (1 << i);
                node = node.get(1-b);
            }else {
                node = node.get(b);
            }
        }

        return xor;
    }

}

class Solution{
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        int[] ans = new int[q];
        Arrays.sort(nums);
        Trie trie = new Trie();
        int[][] sortedq = new int[q][3];

        for(int i = 0; i < q; i++){
            sortedq[i][0] = queries[i][0];
            sortedq[i][1] = queries[i][1];
            sortedq[i][2] = i;
        }

        Arrays.sort(sortedq, (a,b) -> a[1] - b[1]);
        int k = 0;
        for(int i = 0; i < q; i++){
            int x = sortedq[i][0];
            int m = sortedq[i][1];
            int org = sortedq[i][2];

            while(k < n && nums[k] <= m){
                trie.insert(nums[k]);
                k++;
            }
            

            if(trie.root.links[0] == null && trie.root.links[1] == null){
                ans[org] = -1;
            }else ans[org] = trie.getMaxXor(x);
        }

        return ans;

    }
}