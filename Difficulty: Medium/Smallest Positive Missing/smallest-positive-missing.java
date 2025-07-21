

class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        int i = 0;
        int n = arr.length;
        while(i < n){
            if(arr[i] < 1 || arr[i]>n || i == arr[i]-1){
                i++;
            }
            else{
                int idx = arr[i] -1;
                if(arr[i] == arr[idx]){
                    i++;
                }
                else{
                    int temp = arr[i];
                    arr[i] = arr[idx];
                    arr[idx] = temp;
                }
            }
        }
        for(int j = 0 ; j < n ; j++){
            if(j != arr[j] -1 ){
                return j+1;
            }
        }
        return n+1;
    }
}
