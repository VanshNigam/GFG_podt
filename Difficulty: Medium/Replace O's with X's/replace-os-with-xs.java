class Solution {
    static int[] r={1,-1,0,0};
    static int[] c={0,0,1,-1};
    
    
    static boolean isValid(int curRow,int row,int curCol,int col){
        return curRow>=0&&curRow<row&&curCol>=0&&curCol<col;
    }
    
    private static void dfs(int curRow,int curCol,boolean[][] visited,char[][] mat){
        
        if(!isValid(curRow,mat.length,curCol,mat[0].length) || mat[curRow][curCol]!='O'
           || visited[curRow][curCol] )return;
           
           visited[curRow][curCol]=true;
           
           for(int i=0;i<4;i++){
               int tempRow=curRow+r[i];
               int tempCol=curCol+c[i];
               dfs(tempRow,tempCol,visited,mat);
           }
    }
    static char[][] fill(char mat[][]) {
        
        
        
        int m=mat.length;
        int n=mat[0].length;
        
        boolean[][] visited=new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || i==m-1 || j==0 || j==n-1) && mat[i][j]=='O' && !visited[i][j]){
                    dfs(i,j,visited,mat);
                }
            }
        }
        
       
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && mat[i][j]=='O'){
                    mat[i][j]='X';
                }
            }
        }
        
        return mat;
    }
}
