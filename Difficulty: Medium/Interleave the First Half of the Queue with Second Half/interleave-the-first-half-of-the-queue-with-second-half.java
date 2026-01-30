class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
        Stack<Integer> st = new Stack<>();
        int size = q.size();
        for(int i = 0; i < size / 2; i++) {
            st.push(q.poll());
        }
        // push the el of stack back to queue
        while(!st.isEmpty()) {
            q.add(st.pop());
        }
        // move the first half el to the back of the queue
        for(int i = 0; i < size / 2; i++) {
            q.add(q.poll());
        }
        // again push the first half el into the stack
        for(int i = 0; i < size / 2; i++) {
            st.push(q.poll());
        }
        // at last interleave the el of stack and queue and form the required arrangement
        while(!st.isEmpty()) {
            q.add(st.pop());
            q.add(q.poll());
        }
    }
}