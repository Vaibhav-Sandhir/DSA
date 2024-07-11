class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int left = 0;
        int right = 0;
        int length = 0;
        int ind = 0;

        while(left < n){
             if(right < n && chars[left] == chars[right]){
                 length++;
                 right++;
             }
             else{
                 if(length == 1){
                    chars[ind++] = chars[left]; 
                 }
                 else if(length > 1 && length < 10){
                     chars[ind++] = chars[left];
                     chars[ind++] = Character.forDigit(length, 10); 
                 }
                 else if(length >= 10){
                     chars[ind++] = chars[left];
                     int temp = length;
                     int i = 0;
                     char buf[] = new char[4];
                     while(temp > 0){
                         int rem = temp % 10;
                         buf[i++] = Character.forDigit(rem, 10);
                         temp = temp  / 10;
                     }
                     i--;
                     while(i >= 0){
                         chars[ind++] = buf[i--]; 
                     }
                 }
                 left = right;
                 length = 0;
             }
        }
        return ind;
    }
}
