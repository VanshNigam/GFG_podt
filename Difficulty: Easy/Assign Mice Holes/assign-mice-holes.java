class Solution {
    public int assignHole(int[] mices, int[] holes) {
        Arrays.sort(mices);
        Arrays.sort(holes);
        int temp = Integer.MIN_VALUE;
        int i=0;
       while(i<mices.length){
           int k=Math.abs(mices[i]-holes[i]);
           if(temp<k){
               temp=k;
           }
           i++;
       }
       return temp;
        
    }
};