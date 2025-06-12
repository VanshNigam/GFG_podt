class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        // code here
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->
        {
            if(a[0]==b[0])return b[1]-a[1];
            return a[0]-b[0];
        });
        
        for(int i:arr){
            if(i!=x)
                pq.add(new int[]{Math.abs(i-x),i});
        }
        
        int []ans=new int[k];
        while(k>0){
            ans[ans.length-k]=pq.poll()[1];
            k--;
        }
        return ans;
    }
}
