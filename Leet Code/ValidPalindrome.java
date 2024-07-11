class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        List<Character> list = new ArrayList<>();

        for(char ch: s.toCharArray()){
            if((ch >= 97 && ch <= 122) || (ch >= 48 && ch <= 57))
                list.add(ch);
        }

        int n = list.size();
        for(int i = 0, j = n - 1; i < n / 2; i++,j--){
            if(list.get(i) != list.get(j))
                return false;
        }

        return true;
    }
}
