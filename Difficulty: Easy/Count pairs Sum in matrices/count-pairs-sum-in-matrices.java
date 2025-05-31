class Solution {
int countPairs(int mat1[][], int mat2[][], int x) {
        int n=mat1.length;
        int x1 = 0, y1 = 0, x2 = n-1, y2=n-1, count  =0;
        while(x1<n && x2>= 0){
            if(y1==n){
                x1++;
                y1 = 0;
                continue;
            }if(y2<0){
                x2--;
                y2 = n-1;
                continue;
            }
            int sum  = mat1[x1][y1]+mat2[x2][y2];
            if(sum==x){
                count++;
                y2--;
                y1++;
                
            }else if(sum<x){
                y1++;
            }else{
                y2--;
            }
            
        }
        return count;
    }

}