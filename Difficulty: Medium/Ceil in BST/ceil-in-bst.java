/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    int help(Node r, int x ,int prev){
        if(r==null)return prev;
        
        if (r.data == x) return r.data;
        if(r.data>x)return help(r.left,x,r.data);
        else return help(r.right,x,prev);
        }
    int findCeil(Node root, int x) {
        // code here
        return help(root,x,-1);
    }
}