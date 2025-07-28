class Solution {
    public ArrayList<Integer> asciirange(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int[] prefixAscii = new int[s.length()];
        ArrayList<Integer> ans = new ArrayList<>();

        // Build map of character to list of its indices
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);
        }

        // Build prefix sum of ASCII values
        prefixAscii[0] = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            prefixAscii[i] = prefixAscii[i - 1] + s.charAt(i);
        }

        // Process characters with more than 1 occurrence
        for (char key : map.keySet()) {
            List<Integer> indices = map.get(key);
            if (indices.size() > 1) {
                int l = indices.get(0);
                int r = indices.get(indices.size() - 1);
                if (r > l + 1) {
                    // sum of ASCII values from index l+1 to r-1
                    int sum = prefixAscii[r - 1] - prefixAscii[l];
                    ans.add(sum);
                } 
            }
        }

        return ans;

    }
}