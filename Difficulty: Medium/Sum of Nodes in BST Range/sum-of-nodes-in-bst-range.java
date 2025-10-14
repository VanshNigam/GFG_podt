

class Solution {
    int sum=0;
    public void help(Node root,int l,int r){
        if(root==null)return ;
        
        if(root.data>=l && root.data<=r)sum+=root.data;
        help(root.left,l,r);
        help(root.right,l,r);
    }
    public int nodeSum(Node root, int l, int r) {
        // code here
        help(root,l,r);
        return sum;
    }
}
