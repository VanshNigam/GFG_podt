class Solution {
    static String decodeString(String s) {
        // code here
        Stack<Character>stack=new Stack<>();
       for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==']'){
                char ch = ' ';
                String sub="";
                String k="";
                while((ch=stack.pop())!='['){
                    sub=ch+sub;
                }
                while(!stack.isEmpty() && 
                Character.isDigit(stack.peek())){
                    k=stack.pop()+k;
                }
                //repeat k times
                sub=sub.repeat(Integer.parseInt(k));
                for(int j=0;j<sub.length();j++){
                    stack.push(sub.charAt(j));
                }
            }else{
                stack.push(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}