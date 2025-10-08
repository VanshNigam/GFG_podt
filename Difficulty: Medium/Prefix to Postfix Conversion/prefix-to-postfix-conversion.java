class Solution {
    static boolean priority(char c){
        if(c=='^'||c=='*' || c=='/'||c=='+' || c=='-') return false;
        return true;
    }
    static String preToPost(String exp) {
        // code here
        Stack<String>st=new Stack<>();
        String rev = new StringBuilder(exp).reverse().toString();
        
        for(char c:rev.toCharArray()){
            if(priority(c))st.push(c+"");
            else{
                String y=st.pop();
                String x=st.pop();
                
                String ans=y+x+c;
                st.push(ans);
            }
        }
        return st.pop();
    }
}
