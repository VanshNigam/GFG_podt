class Solution {
    public int[] sieve(int n) {
        // code here
        int arr[]=new int[n+1];
        Arrays.fill(arr,1);
        arr[0] = arr[1] = 0;
        
        for(int i=2;i*i<=n;i++){
            if(arr[i]==1){
                for(int j = i * 2; j <= n; j += i){
                    arr[j]=0;
                }
            }
        }
        
        int c=0;
        for(int i=2;i<=n;i++){
            if(arr[i]==1)c++;
        }
        int ans[]=new int[c];
        int k=0;
        for(int i=2;i<=n;i++){
            if(arr[i]==1)ans[k++]=i;
        }
        
        return ans;
    }
}