

class Solution {
    
    public int MaxDistance(HashMap<Node, Node> mp, Node tar) {
        int c = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(tar);
        HashMap<Node, Boolean> vis = new HashMap<>();
        
        vis.put(tar, true);
        while (!q.isEmpty()) {
            int n = q.size();
            int flag = 0;
            for (int i = 0; i < n; i++) {
                Node curr = q.poll();
                if (curr.left != null && vis.get(curr.left) == null) {
                    flag = 1;
                    vis.put(curr.left, true);
                    q.offer(curr.left);
                }
                if (curr.right != null && vis.get(curr.right) == null) {
                    flag = 1;
                    vis.put(curr.right, true);
                    q.offer(curr.right);
                }
                if (mp.get(curr) != null && vis.get(mp.get(curr)) == null) {
                    flag = 1;
                    vis.put(mp.get(curr), true);
                    q.offer(mp.get(curr));
                }
            }
            if (flag == 1) c++;
        }
        return c;
    }
    
    public Node bfs(Node root, HashMap<Node, Node> mp, int target) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node res = new Node(-1);
        
        while (!q.isEmpty()) {
            Node p = q.poll();
            if (p.data == target) res = p;
            
            if (p.left != null) {
                mp.put(p.left, p);
                q.offer(p.left);
            }
            if (p.right != null) {
                mp.put(p.right, p);
                q.offer(p.right);
            }
        }
        return res;
    }
    
    public static int minTime(Node root, int target) {
        HashMap<Node, Node> mp = new HashMap<>();
        
        Solution sol = new Solution();
        Node tar = sol.bfs(root, mp, target);
        int maxi = sol.MaxDistance(mp, tar);
        return maxi;
    }
}