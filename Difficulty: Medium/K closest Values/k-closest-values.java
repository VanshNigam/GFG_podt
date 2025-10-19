class Solution {
    void inorder(Node root, List<Integer> ans) {
        if (root == null) return;
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }

    ArrayList<Integer> getKClosest(Node root, int target, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        
        Collections.sort(ans);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int x : ans) {
            if (q.size() < k) q.offer(x);
            else {
                int t = q.peek();
                if (Math.abs(t - target) > Math.abs(x - target)) {
                    q.poll();
                    q.offer(x);
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) res.add(q.poll());
        return res;
    }
}