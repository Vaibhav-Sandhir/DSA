class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first_string = strs[0];
        String last_string = strs[strs.length-1];
        int ind = 0;
        int n1 = first_string.length();
        int n2 = last_string.length();

        while(ind < n1 && ind < n2){
            if(first_string.charAt(ind) == last_string.charAt(ind)){
                ind++;
            }
            else {
                break;
            }
        }
        return first_string.substring(0, ind);
        
    }
}
