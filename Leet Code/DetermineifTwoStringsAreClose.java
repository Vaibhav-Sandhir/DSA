class Solution {
    public boolean closeStrings(String word1, String word2) {
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        char arr1[] = word1.toCharArray();
        char arr2[] = word2.toCharArray();
        
        if(arr1.length != arr2.length){
            return false;
        }

        for(int i = 0; i < arr1.length; i++){
            freq1[arr1[i] - 'a']++;
            freq2[arr2[i] - 'a']++;
        }

        for(int i = 0; i < arr1.length; i++){
            if(freq2[arr1[i] - 'a'] == 0 || freq1[arr2[i] - 'a'] == 0){
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for(int i = 0; i < 26; i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }

        return true;
    }
}
