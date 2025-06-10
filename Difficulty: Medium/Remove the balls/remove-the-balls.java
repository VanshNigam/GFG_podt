class Solution {
    public int findLength(int[] color, int[] radius) {
        Stack<Integer> colorStack = new Stack<>();
        Stack<Integer> radiusStack = new Stack<>();
        
        for (int i = 0; i < color.length; i++) {
            if (!colorStack.isEmpty() && colorStack.peek() == color[i] && radiusStack.peek() == radius[i]) {
                colorStack.pop();
                radiusStack.pop();
            } else {
                colorStack.push(color[i]);
                radiusStack.push(radius[i]);
            }
        }
        
        return colorStack.size();
    }
}
