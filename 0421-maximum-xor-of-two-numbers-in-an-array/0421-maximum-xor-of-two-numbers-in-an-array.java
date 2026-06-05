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

    int getMaxXOR(int num){
        Node node = root;
        int xor = 0;
        for(int i = 31; i >= 0; i--){
            int b = (num >> i) & 1;

            if(node.containsKey(1-b)){
                xor = xor | (1 << i);
                node = node.get(1-b);
            }else{
                node = node.get(b);
            }
        }
        return xor;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;

        Trie trie = new Trie();

        for(int i = 0; i < n; i++){
            trie.insert(nums[i]);
        }

        int maxxor = 0;
        for(int i = 0; i < n; i++){
            maxxor = Math.max(maxxor, trie.getMaxXOR(nums[i]));
        }

        return maxxor;

    }
}