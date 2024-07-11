class Solution {
    public String removeDuplicates(String s, int k) {
        List<Data> list = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        char arr[] = s.toCharArray();
        list.add(new Data(arr[0], 1));

        for(int i = 1; i < arr.length; i++){
            int n = list.size();
            if(n != 0 && arr[i] == list.get(n - 1).c){
                list.get(n - 1).count++;
                if(list.get(n - 1).count == k){
                    list.remove(n - 1);
                }
            }
            else{
                list.add(new Data(arr[i], 1));
            }
        }
        
        for(int i = 0; i < list.size(); i++){
            Data data = list.get(i);
            for(int j = 0; j < data.count; j++){
                buffer.append(data.c);
            }
        }

        return buffer.toString();
    }
}

class Data{
    char c;
    int count;

    public Data(char c, int count){
        this.c = c;
        this.count = count;
    }
}
