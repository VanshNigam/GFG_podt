// User function Template for Java

class Solution {
    static boolean priority(char c){
        if(c=='^'||c=='*' || c=='/'||c=='+' || c=='-') return false;
        return true;
    }
    static String postToInfix(String exp) {
        // code here
        Stack<String>st=new Stack<>();
        
        for(char c:exp.toCharArray()){
            if(priority(c))st.push(c+"");
            else{
                String x=st.pop();
                String y=st.pop();
                
                String ans="("+y+c+x+")";
                st.push(ans);
            }
        }
        return st.pop();
    }
}
