class Solution {
    public int findMaxFork(Node root, int k) {
        int res = -1;
        while (root != null) {
            if (root.data <= k) {
                res = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return res;
    }
}