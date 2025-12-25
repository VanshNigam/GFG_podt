

class Solution {
    
    public boolean isPresent(int[] arr, int tar){
        int s = 0,  e = arr.length - 1;
        
        while(s <= e){
            int m = s + (e - s) / 2;
            if(arr[m] == tar) return true;
            if(arr[m] < tar) s = m + 1;
            else e = m - 1;
        }
        return false;
    }
    
    public int kthMissing(int[] arr, int k) {
        int n = arr.length;
        int cnt = 0;
        
        for(int i = 1; i <= arr[n-1]; i++){
            if(!isPresent(arr, i)){
                cnt++;
            }
            
            if(cnt == k) return i;
        }
        
        if(cnt < k){
            return arr[n-1] + (k - cnt);
        }
        return -1;
    }
}

