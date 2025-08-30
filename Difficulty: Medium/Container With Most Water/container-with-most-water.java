class Solution {

    public int maxWater(int arr[]) {
        int l=0;
        int r=arr.length-1;
        int res=0;
        while(l<r){
            int w = r - l;//width
            int m = Math.min(arr[l],arr[r]);
            int mul = w * m;
            res = Math.max(res,mul);
            if(arr[l]<arr[r]){
                l++;
            }
            else
                r--;
        }
        return res;
    }
}