
class Solution {
    int max=0;
    int ans=0;
    public void help(int sum,int l,Node r){
        if(r==null)return ;
        sum+=r.data;
        if (r.left == null && r.right == null) {
            if (l > max) {
                max = l;
                ans = sum;
            } else if (l == max) {
                ans = Math.max(ans, sum);
            }
        }
        help(sum,l+1,r.left);
        help(sum,l+1,r.right);
    }
    public int sumOfLongRootToLeafPath(Node root) {
        help(0,0,root);
        return ans;
    }
}