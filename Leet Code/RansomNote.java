class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        char[] note = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        int n = mag.length;
        int m = note.length;
        int freq = 0;

        for(int i = 0; i < n; i++){
            if(!map.containsKey(mag[i])){
                map.put(mag[i], 1);
            }
            else{
                freq = map.get(mag[i]) + 1;
                map.put(mag[i], freq);
            }
        }

        for(int i = 0; i < m; i++){
            if(!map.containsKey(note[i]) || map.get(note[i]) == 0)
                return false;
            else{
                freq = map.get(note[i]) - 1;
                map.put(note[i], freq);
            }  
        }
        return true;
    }
}
