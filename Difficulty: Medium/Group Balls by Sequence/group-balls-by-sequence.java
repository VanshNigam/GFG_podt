class Solution {
    public boolean validgroup(int[] arr, int k) {
        Arrays.sort(arr);

        if (arr.length % k != 0) return false;
        if (k == 1) return true;

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : arr) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (!mp.containsKey(val)) continue;

            int count = mp.get(val); // number of times this value needs to be grouped
            for (int j = 0; j < k; j++) {
                int curr = val + j;
                if (!mp.containsKey(curr) || mp.get(curr) < count) return false;

                // reduce count
                mp.put(curr, mp.get(curr) - count);
                if (mp.get(curr) == 0) mp.remove(curr);
            }
        }

        return true;
    }
}
