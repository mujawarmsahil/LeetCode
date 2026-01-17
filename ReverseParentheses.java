class ReverseParentheses {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(new StringBuilder());
            } else if (c == ')') {
                StringBuilder top = stack.pop().reverse();
                stack.peek().append(top);
            } else {
                stack.peek().append(c);
            }
        }

        return stack.pop().toString();
    }
}
