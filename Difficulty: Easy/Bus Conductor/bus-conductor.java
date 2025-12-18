class Solution {
    public int findMoves(int[] chairs, int[] passengers) {
        // code here
        Arrays.sort(chairs);
        Arrays.sort(passengers);
        
        int ans=0;
        for(int i=0;i<chairs.length;i++){
            ans+=Math.abs(chairs[i]-passengers[i]);
        }
        return ans;
    }
}
