// User function Template for Java

class Solution {
    int help(Node r, int x ,int prev){
        if(r==null)return prev;
        
        if (r.data == x) return r.data;
        if(r.data>x)return help(r.left,x,prev);
        else return help(r.right,x,r.data);
    }
    public int floor(Node root, int x) {
        // Code here
        return help(root,x,-1);
    }
}