class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                if (stack.size() > 1) {
                    sb.append('(');
                }
            }

            if (s.charAt(i) == ')') {
                if(stack.size()==1){
                    stack.pop();
                }
                if (stack.size() > 1) {
                    stack.pop();
                    sb.append(')');
                }
            }

        }

        return sb.toString();
    }
}