//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) image[i][j] = Integer.parseInt(S2[j]);
            }
            int sr = Integer.parseInt(br.readLine().trim());
            int sc = Integer.parseInt(br.readLine().trim());
            int newColor = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
   static class Node{
        int row,col;
        public Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int n=image.length,m=image[0].length;
        boolean[][] visited=new boolean[n][m];
        int[][] direction={{0,-1},{-1,0},{0,1},{1,0}};
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(sr,sc));
        
        while(!q.isEmpty()){
            Node curr=q.remove();
            visited[curr.row][curr.col]=true;
            for(int[] dir:direction){
                int newRow=dir[0]+curr.row;
                int newCol=dir[1]+curr.col;
                if(newRow>=0&&newRow<n&&newCol>=0&&newCol<m&&
                            image[newRow][newCol]==image[sr][sc]&&!visited[newRow][newCol]){
                    image[newRow][newCol]=newColor;
                    q.add(new Node(newRow,newCol));
                }
            }
        }
        image[sr][sc]=newColor;
        return image;
    }


}