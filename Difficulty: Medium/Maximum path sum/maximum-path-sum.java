

/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    int max=Integer.MIN_VALUE;
    
    int help(Node r){
        if(r==null)return 0;
        int leftSum=help(r.left);
        int rightSum=help(r.right);
        
        if(leftSum >0 && rightSum>0)
                max=Math.max(max,r.data+leftSum+rightSum);
        else if(leftSum <0 && rightSum<0)
                max=Math.max(max,r.data);
        else 
                max=Math.max(max,r.data+Math.max(leftSum,rightSum));
        
        return Math.max(0,r.data+Math.max(leftSum,rightSum));
    }
    int findMaxSum(Node root) {
        if(root==null)return 0;
        help(root);
        
        return max;
    }
}
