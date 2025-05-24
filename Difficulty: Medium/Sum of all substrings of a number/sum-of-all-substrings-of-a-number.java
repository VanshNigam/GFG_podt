class Solution {
    public static int sumSubstrings(String s) {
        // code here
        int n = s.length();
        int totalsum = 0, prevsum = 0;
        
        for(int i = 0; i < n; i++){
            int num = s.charAt(i) - '0';
            prevsum = prevsum * 10 + (i + 1) * num;
            totalsum += prevsum;
        }
        return totalsum;
    }
}