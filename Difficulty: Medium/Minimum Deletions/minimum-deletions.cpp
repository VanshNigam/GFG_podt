class Solution {
  public:
    int minDeletions(string s) {
        // code here
        // we use longest palindrome sequence technique
        
        int n=s.size();
        vector<int> cur(n,0); // current palindrome 
        
         vector<int> pre(n,0); // hold previous value of curr vector
         
         for(int i=n-1;i>=0;i--){
             cur[i]=1;
             
             for(int j=i+1;j<n;j++){
                 if(s[i] == s[j]){
                     cur[j]=pre[j-1]+2;
                 }
                 else{
                     cur[j]=max(pre[j],cur[j-1]);
                 }
             }
             pre=cur;
         }
         
         // cur[n-1] ye contain karega longest palindrome subsequence ki length
         
         return n-cur[n-1];
        
    }
};