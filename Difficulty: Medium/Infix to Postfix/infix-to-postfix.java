class Solution {
    static int priority(char c){
        if(c=='^') return 3;
        if(c=='*' || c=='/') return 2;
        if(c=='+' || c=='-') return 1;
        return -1;
    }
    public static String infixToPostfix(String s) {
        // code here
        Stack<Character>st=new Stack<>();
        String res="";
        
        for(char ch:s.toCharArray()){
            if(Character.isLetterOrDigit(ch)) res+=ch;
            
            else if(ch=='(')st.push(ch);
            
            else if(ch==')'){
                //pop condition --1.) 
                //              --2.low priority
                while(!st.isEmpty() && st.peek()!='('){
                    res+=st.pop();
                }
                st.pop();
            }
            else {
                while(!st.isEmpty() && priority(st.peek())>=priority(ch) && ch != '^'){
                    res+=st.pop();
                }
                st.push(ch);
            }
        }
         while(!st.isEmpty()) res+=st.pop();
                
        return res;
    }
}