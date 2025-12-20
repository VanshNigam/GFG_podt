class Solution {
    public int searchInsertK(int arr[], int k) {
        // code here
        int n=arr.length;
        
        int st=0;
        int end=n-1;
        
        while(st <= end){
            int mid = st + (end - st) / 2;
        
            if(arr[mid] == k) return mid;
        
            if(arr[mid] > k) end = mid - 1;
            else st = mid + 1;  // <-- main fix
        }
        return st;

    }
};