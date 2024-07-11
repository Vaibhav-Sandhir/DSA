class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int i = 0;
        int n = words.length;

        while(i < n){
            int j = i + 1;
            int lineLength = words[i].length();
            while(j < n && isExceeding(lineLength, words,i,j,maxWidth)){
                lineLength += words[j].length();
                j++;
            }

            int totalSpaces = maxWidth - lineLength;
            int numberOfWords = j - i;
            if(numberOfWords == 1 || j >= n)
                result.add(leftJustify(words, totalSpaces, i, j, numberOfWords));
            else
                result.add(middleJustify(words, totalSpaces, i, j, numberOfWords));
            i = j;        
        }
        return result;
    }

    private boolean isExceeding(int lineLength, String[] words, int i, int j, int maxWidth){
        return lineLength + words[j].length() + j - i - 1 < maxWidth;
    }

    private String leftJustify(String[] words, int totalSpaces, int i, int j, int numberOfWords){
        int spacesOnRight = totalSpaces - (numberOfWords - 1);

        StringBuilder result = new StringBuilder(words[i]);
        for(int k = i + 1; k < j; k++){
            result.append(" " + words[k]);
        }
        result.append(" ".repeat(spacesOnRight));

        return result.toString();
    }

    private String middleJustify(String[] words, int totalSpaces, int i, int j, int numberOfWords){
        int groups = numberOfWords - 1;
        int spacePerGroup = totalSpaces / groups;
        int extraSpaces = totalSpaces % groups;

        StringBuilder result = new StringBuilder(words[i]);
        for(int k = i + 1; k < j; k++){
            int spacesToApply = spacePerGroup + (extraSpaces-- > 0 ? 1 : 0);
            result.append(" ".repeat(spacesToApply) + words[k]);
        }

        return result.toString();
    }
}
