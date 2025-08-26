/*Complete the function below*/
class GfG {
    public void reverse(Stack<Integer> s,int x){
        if(s.isEmpty() || s.peek() <= x ){
            s.push(x);
            return;
        }
            int pop=s.pop();
            reverse(s,x);
            s.push(pop);
    }
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        if (s.isEmpty()) return s;

        int peek=s.pop();
        
        sort(s);
        reverse(s,peek);
        return s;
    }
}