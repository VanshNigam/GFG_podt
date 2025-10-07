class Solution {

  public:
    
    int preIndex = 0, posIndex = 0;
    
    Node *constructTree(vector<int> &pre, vector<int> &post) {
        // code here
        
        Node* root = new Node(pre[preIndex++]);
        
        if(root->data != post[posIndex]){
            root->left = constructTree(pre, post);
        }
            
        if(root->data != post[posIndex]){
            root->right = constructTree(pre, post);
        }
            
        posIndex++;
        
        return root;
    }
};