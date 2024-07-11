class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            char c = (s.length() == 1) ? s.charAt(0) : ' ';
            if(c == '+' || c == '-' || c == '*' || c == '/'){
                int num2 = stack.pop();
                int num1 = stack.pop();
                int ans = 0;
                if(c == '+'){
                    ans = num1 + num2;
                }
                else if(c == '-'){
                    ans = num1 - num2;
                }
                else if(c == '*'){
                    ans = num1 * num2;
                }
                else{
                    ans = num1 / num2;
                }
                stack.push(ans);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.peek();
    }
}
