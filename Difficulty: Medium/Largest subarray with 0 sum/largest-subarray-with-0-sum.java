class Solution {
    int maxLength(int arr[]) {
        // code here
        int max=0;
        Map<Integer,Integer>mp=new HashMap<>();
        
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if (sum == 0) max = Math.max(max, i + 1);
            if(mp.containsKey(sum)){
                max=Math.max(max,i-mp.get(sum));
            }else{
                mp.put(sum,i);
            }
        }
        
        return max;
    }
}