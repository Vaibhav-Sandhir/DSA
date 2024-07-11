class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        
        for(String s : operations){
            char c = s.charAt(0);
            if(c == 'C'){
                stack.pop();
            }
            else if(c == 'D'){
                stack.push(stack.peek() * 2);
            }
            else if(c == '+'){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2);
                stack.push(num1);
                stack.push(num1 + num2);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }

        while(!stack.isEmpty()){
            ans += stack.pop();
        }

        return ans;
    }
}
