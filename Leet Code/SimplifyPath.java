class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Stack<String> s2 = new Stack<>();
        StringBuilder buffer = new StringBuilder();
        path = path + "/";
        int n = path.length();

        for(int i = 0; i < n; i++){
            char c = path.charAt(i);
            if(c == '/'){
                String str = buffer.toString();
                if(str.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }
                else if(!str.equals("") && !str.equals(".")){
                    stack.push(str);
                }
                buffer.delete(0, buffer.length());
            }
            else{
                buffer.append(c);
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        while(!stack.isEmpty()){
            s2.push(stack.pop());
        }
        while(!s2.isEmpty()){
            buffer.append("/");
            buffer.append(s2.pop());
        }

        return buffer.toString();
    }
}
