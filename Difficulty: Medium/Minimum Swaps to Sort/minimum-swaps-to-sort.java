class Solution {
    public void swap(int [] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    public int minSwaps(int arr[]) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i = 0; i<n; i++){
            map.put(arr[i],i);
        }
        
        Arrays.sort(arr);
        int i = 0;
        int count = 0;
        
        while(i < n){
            if(i != map.get(arr[i])){
                count++;
                swap(arr,i,map.get(arr[i]));
            }else{
                i++;
            }
        }
        return count;
    }
}