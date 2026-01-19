class Solution {
    String s="";
    Stack<Character>st=new Stack<>();
    public void append(char x) {
        // append x into document
        s+=x;
    }

    public void undo() {
        // undo last change
        int n=s.length();
        char rem=s.charAt(n-1);
        st.push(rem);
        
        s=s.substring(0,n-1);
    }

    public void redo() {
        // redo changes
        if(!st.isEmpty())s=s+st.pop();
    }

    public String read() {
        // read the document
        return s;
    }
}
