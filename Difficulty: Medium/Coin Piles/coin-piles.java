class Solution {
    public int upperInd(int arr[], int x, int i){
        int low = i;
        int high = arr.length - 1;
        int ind = arr.length; // Important: default to n

        while(low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] > x){
                ind = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ind;
    }

    public int minimumCoins(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        int[] psum = new int[n];
        psum[0] = arr[0];
        for(int i = 1; i < n; i++)
            psum[i] = psum[i - 1] + arr[i];

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int pre = (i == 0) ? 0 : psum[i - 1];

            int ind = upperInd(arr, arr[i] + k, i);

            int total = (ind == n) ? 0 : (ind == 0 ? psum[n - 1] : psum[n - 1] - psum[ind - 1]);

            int allow = (n - ind) * (arr[i] + k);
            int ext = pre + total - allow;

            min = Math.min(min, ext);
        }
        return min;
    }
}
