class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        // code here
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int val : arr)
        {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        for(int i=n-1; i>=0; i--)
        {
            int num = arr[i];
            while(st.size() > 0 && map.get(num) >= map.get(st.peek()))
            {
                st.pop();
            }
            if(st.size() == 0)
            {
                result.add(-1);
            }
            else
            {
                result.add(st.peek());
            }
            st.push(num);
        }
        
        Collections.reverse(result);
        
        return result;
    }
}