class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        char arr[] = s.toCharArray();
        int n = arr.length;
        int length = -1;
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], i);
            }
            else{
                length = Math.max(length, i - map.get(arr[i]) - 1);
            }
        }

        return length;
    }
}
