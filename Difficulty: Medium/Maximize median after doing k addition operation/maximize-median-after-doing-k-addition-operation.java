class Solution {
    public int maximizeMedian(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        if(n%2 == 0) pq.add(arr[n/2 - 1]);
        
        for(int i=n/2; i<n; i++) {
            pq.add(arr[i]);
        }
        
        for(int i=0; i<k; i++) {
            int val = pq.poll();
            pq.add(val+1);
        }
        
        if(n%2 == 0) {
            int val = pq.poll();
            val += pq.poll();
            return val/2;
        }
        return pq.poll();
    }
}

