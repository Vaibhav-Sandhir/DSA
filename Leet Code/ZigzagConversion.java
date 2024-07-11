class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }

        int n = s.length();
        char[] array = new char[n];
        int ind = 0;
        for(int row = 0; row < numRows; row++){
            int i = row;
            while(i < n){
                int increment =  2 * (numRows - 1);
                array[ind++] = s.charAt(i);
                if(row > 0 && row < numRows - 1 && i + increment - 2 * row < n){
                    array[ind++] = s.charAt(i + increment - 2 * row);
                }
                i += increment;
            }
        }
        return new String(array);
    }
} 
