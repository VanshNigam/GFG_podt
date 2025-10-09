
class Solution 
{
    public static void postOrderTriversal(ArrayList<Integer> list, Node root){
        if(root == null){
            return;
        }
        postOrderTriversal(list,root.left);
        postOrderTriversal(list,root.right);
        list.add(root.data);
    }
    //Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root)
    {
       // Your code goes here
       ArrayList<Integer> list = new ArrayList<>();
       postOrderTriversal(list,root);
       return list;
    }
}
