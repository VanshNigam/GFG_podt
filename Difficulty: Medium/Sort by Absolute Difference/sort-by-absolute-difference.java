class Solution {
    public void rearrange(int[] arr, int x) {
        // Convert int[] to Integer[] for custom sorting
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> Math.abs(x - a) - Math.abs(x - b));

        // Copy back to original int[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}
