class Solution {
    public int maxSum(int arr[]) {
        // code here
        int max=0;
        for(int i=1;i<arr.length;i++){
            if((arr[i]+arr[i-1])>max)max=arr[i]+arr[i-1];
        }
        return max;
    }
}