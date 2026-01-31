class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        int n=arr.length;
        Stack<Integer>st=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&& st.peek()<=arr[i]) st.pop();
            
            if(!st.isEmpty()&& st.peek()>arr[i]) ans.add(st.peek());
            else ans.add(-1);
            
            st.push(arr[i]);
        }
        Collections.reverse(ans);
        return ans;
    }
}