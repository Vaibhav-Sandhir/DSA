class Solution {
    public String removeDuplicates(String s) {
        StringBuilder buffer = new StringBuilder();

        for(char c : s.toCharArray()){
            int n = buffer.length();
            if(n != 0 && buffer.charAt(n - 1) == c){
                buffer.deleteCharAt(n - 1);
            }
            else{
                buffer.append(c);
            }
        }

        return buffer.toString();
    }
}
