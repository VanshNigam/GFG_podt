class Solution {
    static class Pair {
        int sum, i, j;
        Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }
     
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (arr1.length == 0 || arr2.length == 0 || k == 0) return result;
         
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.sum - b.sum);
         
        for (int i = 0; i < Math.min(k, arr1.length); i++)
            minHeap.offer(new Pair(arr1[i] + arr2[0], i, 0));
         
        while (k-- > 0 && !minHeap.isEmpty()) {
            Pair current = minHeap.poll();
            int i = current.i;
            int j = current.j;
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(arr1[i]);
            pair.add(arr2[j]);
            result.add(pair);
                
            if (j + 1 < arr2.length)
                minHeap.offer(new Pair(arr1[i] + arr2[j + 1], i, j + 1));
        }
         
        return result;
    }
}