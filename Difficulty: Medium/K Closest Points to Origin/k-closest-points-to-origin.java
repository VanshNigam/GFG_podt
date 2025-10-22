class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        PriorityQueue<Pair1> queue = new PriorityQueue<>((a, b) -> b.dis - a.dis);

        for (int i = 0; i < points.length; i++) {
            int val1 = points[i][0];
            int val2 = points[i][1];
            int dis = val1 * val1 + val2 * val2;

            queue.add(new Pair1(dis, val1, val2));
            if (queue.size() > k) queue.remove();
        }

        while (!queue.isEmpty()) {
            Pair1 p = queue.remove();
            res.add(new ArrayList<>(Arrays.asList(p.x, p.y)));
        }

        return res;
    }
}

class Pair1 {
    int dis, x, y;
    Pair1(int dis, int x, int y) {
        this.dis = dis;
        this.x = x;
        this.y = y;
    }
}
