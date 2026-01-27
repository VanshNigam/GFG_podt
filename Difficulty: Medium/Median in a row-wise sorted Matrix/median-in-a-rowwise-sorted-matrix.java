class Solution {
    public int median(int[][] nums) {
        int row = nums.length;
        int cols = nums[0].length;
        int[] arr = new int[row * cols];
        int index = 0;
        for(int i = 0;i < nums.length;i++){
            for(int j = 0;j <nums[0].length;j++){
                arr[index++] = nums[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[arr.length / 2];
        
    }
}