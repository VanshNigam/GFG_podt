class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        // Step 1️⃣: Add all 1's to queue (multi-source BFS)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                    vis[i][j] = true;
                }
            }
        }

        // Step 2️⃣: BFS from all 1's
        while (!q.isEmpty()) {
            int[] a = q.poll();
            int x = a[0], y = a[1], d = a[2];
            dist[x][y] = d;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    q.add(new int[]{nx, ny, d + 1});
                }
            }
        }

        // Step 3️⃣: Convert to ArrayList<ArrayList<Integer>>
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int[] row : dist) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int num : row) temp.add(num);
            ans.add(temp);
        }

        return ans;
    }
}
