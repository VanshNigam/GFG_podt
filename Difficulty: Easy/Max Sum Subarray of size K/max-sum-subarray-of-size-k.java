class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int low=0;
        int high=k-1;
        int n = arr.length;
        int sum=0;
        for(int i=low; i<=high; i++){
            sum = sum + arr[i];
        }
        int res=0;
        while(high<n){
            res = Math.max(sum,res);
            low++;
            high++;
            if(high==n){
                break;
            }
            sum = sum - arr[low-1];     
            sum = sum + arr[high];
        }
        return res;
    }
}