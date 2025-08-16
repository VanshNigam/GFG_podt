import java.util.*;

class Solution {
    public String findLargest(int[] arr) {
        if (arr.length == 1) {
            return arr[0] + "";
        }

        // Convert int[] to Integer[] so we can use custom comparator
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // Sort using comparator (compare concatenated strings)
        Arrays.sort(nums, (a, b) -> (b + "" + a).compareTo(a + "" + b));

        // If the largest number is 0, return "0" (handles cases like [0,0])
        if (nums[0] == 0) return "0";

        StringBuilder str = new StringBuilder();
        for (int num : nums) {
            str.append(num);
        }
        return str.toString();
    }
}
