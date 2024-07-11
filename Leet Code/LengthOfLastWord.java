class Solution {
    public int lengthOfLastWord(String s) {
        s = s.strip();
        int n = s.length();
        int ind = n - 1;
        int count = 0;

        while(ind >= 0 && s.charAt(ind) != ' '){
            count++;
            ind--;
        }

        return count;
    }
}
