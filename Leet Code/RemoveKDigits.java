class Solution {
    public String removeKdigits(String num, int k) {
        StringBuffer buffer = new StringBuffer();
        char arr[] = num.toCharArray();
        int n = arr.length;
        buffer.append(arr[0]);
        int ind = 0;

        for(int i = 1; i < n; i++){
            char c1 = arr[i];
            int num1 = Character.getNumericValue(c1);
            while(ind >= 0 && k > 0){
                char c2 = buffer.charAt(ind);
                int num2 = Character.getNumericValue(c2);
                if(num2 > num1){
                    buffer.deleteCharAt(ind);
                    ind--;
                    k--;
                }
                else{
                    break;
                }
            }
            buffer.append(c1);
            ind++;
        }

        while(k > 0 && ind >= 0){
            buffer.deleteCharAt(buffer.length() - 1);
            ind--;
            k--;
        }

        while(ind >= 0 && buffer.charAt(0) == '0'){
            buffer.deleteCharAt(0);
            ind--;
        }

        return (ind < 0) ? "0" : buffer.toString();
    }
}
