// class Solution {
//     public int celebrity(int mat[][]) {
//         // code here
//         int n = mat.length;
//         if(n==1) return 0;
//         int arr[] = new int[n];
//         for(int i=0;i<n;i++)
//         {
//             for(int j=0;j<n;j++)
//             {
//                 if(mat[i][j]==1)
//                 {
//                     arr[j]++;
//                     arr[i]--;
//                 }
//             }
//         }
//         for(int i=0;i<n;i++)
//         {
//             if(arr[i] == n-1) return i;
//         }
//         return -1;
//     }
// }
class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;

        // Step 1: Find candidate
        int cand = 0;
        for (int i = 1; i < n; i++) {
            if (mat[cand][i] == 1) {
                // cand knows i => cand cannot be celebrity
                cand = i;
            }
        }

        // Step 2: Verify candidate
        for (int i = 0; i < n; i++) {
            if (i != cand) {
                if (mat[cand][i] == 1 || mat[i][cand] == 0) {
                    return -1; // cand knows someone OR someone doesn't know cand
                }
            }
        }

        return cand;
    }
}
