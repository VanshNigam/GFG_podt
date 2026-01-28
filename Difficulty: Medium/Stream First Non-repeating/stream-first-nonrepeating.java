class Solution {
    public String firstNonRepeating(String s) {
        // code here
        int[] map = new int[26];
        Queue<Character> qt = new LinkedList<>();
        
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            map[ch - 'a']++;
            if(map[ch - 'a'] == 1) {
                qt.offer(ch);
            }
            else {
                while(!qt.isEmpty() && map[qt.peek() - 'a'] > 1)
                    qt.poll();
            }
            sb.append(qt.isEmpty() ? '#' : qt.peek());
        }
        return sb.toString(); 
    }
}