

// User function Template for Java
class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
        int max=0;
        for(int i:left)max=Math.max(i,max);
        for(int i:right)max=Math.max(n-i,max);
        return max;
    }
}