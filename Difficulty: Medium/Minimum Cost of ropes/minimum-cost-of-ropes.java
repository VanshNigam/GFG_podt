

class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        
        for(int i:arr)pq.add(i);
        int ans=0;
        
        while(!pq.isEmpty()){
            int a=pq.poll();
            
            if(pq.isEmpty()){
                return ans;
            }
            
            int b=pq.poll();
            ans+=(a+b);
            
            pq.add(a+b);
        }
        return ans;
    }
}