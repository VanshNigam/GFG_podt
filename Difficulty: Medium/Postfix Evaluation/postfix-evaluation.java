class Solution {
    public int evaluatePostfix(String[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        for (String s : arr) {
            if (Character.isDigit(s.charAt(0)) ||(s.length() > 1 && s.charAt(0) == '-' && Character.isDigit(s.charAt(1)))) {
                st.push(Integer.parseInt(s));
            } else {
                int b = st.pop();
                int a = st.pop();
                int c = 0;

                switch (s) {
                    case "+":
                        c = a + b;
                        break;
                    case "-":
                        c = a - b;
                        break;
                    case "*":
                        c = a * b;
                        break;
                    case "/":
                        c = Math.floorDiv(a, b);;
                        break;
                    case "^":
                        c = (int) Math.pow(a, b);
                        break;
                }

                st.push(c);
            }
        }
        return st.pop();
    }
}