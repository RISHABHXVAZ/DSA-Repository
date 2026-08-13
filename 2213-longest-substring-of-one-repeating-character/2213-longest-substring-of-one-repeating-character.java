class Solution {
    class Node {
        int maxLen = 1, ll = 1, lr = 1, len = 1;
        char cl, cr;
    }

    Node[] tree;

    void refresh(int node) {
        Node n = tree[node];
        Node l = tree[node * 2];
        Node r = tree[node * 2 + 1];

        n.cl = l.cl;
        n.cr = r.cr;
        n.len = l.len + r.len;

        // Prefix length: starts with left child's prefix
        n.ll = l.ll;
        // If the entire left child is uniform and matches right child's start character
        if (l.ll == l.len && l.cr == r.cl) {
            n.ll += r.ll;
        }

        // Suffix length: starts with right child's suffix
        n.lr = r.lr;
        // If the entire right child is uniform and matches left child's end character
        if (r.lr == r.len && r.cr == l.cr) {
            n.lr += l.lr;
        }

        // Max repeating length across left, right, or bridging the middle
        n.maxLen = Math.max(l.maxLen, r.maxLen);
        if (l.cr == r.cl) {
            n.maxLen = Math.max(n.maxLen, l.lr + r.ll);
        }
    }

    void build(String s, int node, int start, int end) {
        tree[node] = new Node();
        if (start == end) {
            tree[node].cl = s.charAt(start);
            tree[node].cr = s.charAt(start);
            tree[node].maxLen = 1;
            tree[node].ll = 1;
            tree[node].lr = 1;
            tree[node].len = 1;
            return;
        }

        int mid = start + (end - start) / 2;
        build(s, node * 2, start, mid);
        build(s, node * 2 + 1, mid + 1, end);
        refresh(node);
    }

    void update(int node, int start, int end, int idx, char c) {
        if (start == end) {
            tree[node].cl = c;
            tree[node].cr = c;
            tree[node].maxLen = 1;
            tree[node].ll = 1;
            tree[node].lr = 1;
            return;
        }

        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(node * 2, start, mid, idx, c);
        } else {
            update(node * 2 + 1, mid + 1, end, idx, c);
        }
        refresh(node);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        tree = new Node[4 * n];
        build(s, 1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = tree[1].maxLen; // Root always keeps track of the global maximum
        }

        return ans;
    }
}