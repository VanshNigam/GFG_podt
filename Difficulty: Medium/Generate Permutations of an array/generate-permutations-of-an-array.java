class Solution {
    static void solve(ArrayList<ArrayList<Integer>>ans, Map<Integer, Integer> map, int len, ArrayList<Integer> curr) {
        if(curr.size() == len) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int key : map.keySet()) {
            if(map.get(key) > 0) {
                map.put(key, 0);
                curr.add(key);
                
                solve(ans, map, len, curr);
                
                curr.remove(curr.size() - 1);
                map.put(key, 1);
            }
        }
    }
    
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], 1);
        }    
        solve(ans, map, arr.length, new ArrayList<>());
        return ans;
        
    }
};