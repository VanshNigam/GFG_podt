// User function Template for Java
class DisjointSet{
    List<Integer>rank=new ArrayList<>();
    List<Integer>parent=new ArrayList<>();
    List<Integer>size=new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findParent(int n){
        if(n==parent.get(n))return n;
        
        int GrandFather=findParent(parent.get(n));
        parent.set(n,GrandFather);
        
        return GrandFather;
    }
    
    public void unionBySize(int u,int v){
        int father_u=findParent(u);
        int father_v=findParent(v);
        
        if(father_v==father_u)return;
        
        if(size.get(father_v)<size.get(father_u)){
            parent.set(father_u,father_v);
            size.set(father_u,size.get(father_v)+size.get(father_u));
        }
        else{
            parent.set(father_v,father_u);
            size.set(father_v,size.get(father_v)+size.get(father_u));
        }
    }
    
}
class Solution {
    int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

    public List<Integer> numOfIslands(int rows, int cols, int[][] q) {
        // Your code here
        int vis[][]=new int[rows][cols];
        DisjointSet ds=new DisjointSet(rows*cols);
        List<Integer>ans=new ArrayList<>();
        
        int count = 0;
        for(int[] i : q){
            int r = i[0], c = i[1];
            if(vis[r][c]==1){
                ans.add(count);
                continue;
            }
            vis[r][c]=1;
            count++;
        
            int node = r*cols + c;
            for(int[] d : dir){
                int nr=r+d[0], nc=c+d[1];
                if(nr>=0 && nc>=0 && nr<rows && nc<cols && vis[nr][nc]==1){
                    int adj = nr*cols + nc;
                    if(ds.findParent(node)!=ds.findParent(adj)){
                        count--;
                        ds.unionBySize(node, adj);
                    }
                }
            }
            ans.add(count);
        }

        return ans;
    }
}