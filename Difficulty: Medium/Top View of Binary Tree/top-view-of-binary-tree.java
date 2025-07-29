class Pair {
    Node node;
    int row;

    public Pair(Node node, int row) {
        this.node = node;
        this.row = row;
    }
}

class Solution {
    // Function to return a list containing the top view of the given tree.
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> al = new ArrayList<>();
        if (root == null) return al;

        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node temp = p.node;
            int row = p.row;

            // For top view: only set the first time a horizontal distance is encountered
            if (!tm.containsKey(row)) {
                tm.put(row, temp.data);
            }

            if (temp.left != null) q.add(new Pair(temp.left, row - 1));
            if (temp.right != null) q.add(new Pair(temp.right, row + 1));
        }

        for (Map.Entry<Integer, Integer> e : tm.entrySet()) {
            al.add(e.getValue());
        }

        return al;
    }
}
