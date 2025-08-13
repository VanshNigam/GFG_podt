class Solution {
    public int minSoldiers(int[] arr, int k) {
        // code here
        int n=(arr.length+1)/2;
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        
        for(int i:arr){
            int temp=i%k;
            if(temp==0)n--;
            pq.add(i%k);
        }
        int ans=0;
        while(n > 0 && !pq.isEmpty()){
            n--;
            ans+=(k-pq.poll());
        }
        return ans;
    }
}

