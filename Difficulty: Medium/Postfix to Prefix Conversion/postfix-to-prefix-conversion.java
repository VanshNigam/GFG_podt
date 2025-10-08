class Solution {
    static boolean priority(char c){
        if(c=='^'||c=='*' || c=='/'||c=='+' || c=='-') return false;
        return true;
    }
    static String postToPre(String exp) {
        // code here
        Stack<String>st=new Stack<>();
        
        for(char c:exp.toCharArray()){
            if(priority(c))st.push(c+"");
            else{
                String x=st.pop();
                String y=st.pop();
                
                String ans=c+y+x;
                st.push(ans);
            }
        }
        return st.pop();
    }
}
