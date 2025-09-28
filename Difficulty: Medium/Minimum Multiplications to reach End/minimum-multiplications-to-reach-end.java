// User function Template for Java

class Solution {
    int mod=100000;
        int minimumMultiplications(int[] arr, int st, int end) {
        int[] dist = new int[mod];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
    
        q.add(st);
        dist[st] = 0;
        if(st==end)return 0;
    
        while (!q.isEmpty()) {
            int node = q.poll();
            int steps = dist[node];
    
            for (int mul : arr) {
                int nxt = (node * mul) % mod;
                if (dist[nxt] > steps + 1) {
                    dist[nxt] = steps + 1;
                    if (nxt == end) return dist[nxt]; // 🎯 found shortest
                    q.add(nxt);
                }
            }
        }
        return -1; // unreachable
    }
}
