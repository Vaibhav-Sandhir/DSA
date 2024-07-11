class Solution {
public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int left = 0, right = 0; right< s.length();right++){
            char current = s.charAt(right);
            if(map.containsKey(current) && map.get(current) >= left){
                left = map.get(current) + 1;
            }
            map.put(current,right);
            max = Math.max(max,right - left + 1);
        }
        return max;
    }
}
