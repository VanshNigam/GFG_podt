class Solution {
    public static boolean checkRedundancy(String s) {

        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(0);
            }
            if(s.charAt(i) == ')'){
                if(st.peek() == 0){
                    return true;
                }else{
                    st.pop();                }
            }
            
            if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/'){
                if(!st.isEmpty()){
                    st.pop();
                    st.push(1);
                }
            }
        }
        return false;
    }
}