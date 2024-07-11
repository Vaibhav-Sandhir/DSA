class Solution {
    public int romanToInt(String s) {
        int number = 0;
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for(int i = 0; i < n; i++){
            if(i < n - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
                number += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                i = i + 1;
            }
            else{
                number += map.get(s.charAt(i));
            }
        }
        return number;
    }
}
