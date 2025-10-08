import java.util.*;

class Solution {
    static int priority(char c){
        if(c=='^') return 3;
        if(c=='*' || c=='/') return 2;
        if(c=='+' || c=='-') return 1;
        return -1;
    }

    public static String infixToPrefix(String s) {
        Stack<Character> st = new Stack<>();
        String res = "";

        // Step 1: Reverse string
        String rev = new StringBuilder(s).reverse().toString();

        // Step 2: Swap brackets
        StringBuilder sb = new StringBuilder();
        for(char ch : rev.toCharArray()){
            if(ch == '(') sb.append(')');
            else if(ch == ')') sb.append('(');
            else sb.append(ch);
        }
        String exp = sb.toString();

        // Step 3: Apply infix → postfix logic
        for(char ch : exp.toCharArray()){
            if(Character.isLetterOrDigit(ch)) res += ch;
            else if(ch == '(') st.push(ch);
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    res += st.pop();
                }
                if(!st.isEmpty()) st.pop(); // ✅ Safe pop
            } else {
                while(!st.isEmpty() && 
                      (priority(st.peek()) > priority(ch) || 
                       (priority(st.peek()) == priority(ch) && ch == '^'))){
                    res += st.pop();
                }
                st.push(ch);
            }
        }

        while(!st.isEmpty()) res += st.pop();

        // Step 4: Reverse result
        return new StringBuilder(res).reverse().toString();
    }
}
