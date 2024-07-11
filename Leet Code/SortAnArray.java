class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return new int[]{nums[0]}; 
        }
        int n1 = n / 2;
        int n2 = n - n1;

        int arr1[] = new int[n1];
        int arr2[] = new int[n2];

        for(int i = 0; i < n1; i++){
            arr1[i] = nums[i];
        }
        for(int i = 0; i < n2; i++){
            arr2[i] = nums[i + n1];
        }

        sortArray(arr1);
        sortArray(arr2);
        return merge(arr1, arr2, nums);
    }

    private int[] merge(int arr1[], int arr2[], int nums[]){
        int m = arr1.length;
        int n = arr2.length;
        int ind = 0;
        int i = 0;
        int j = 0;

        while(i < m && j < n){
            if(arr1[i] <= arr2[j]){
                nums[ind++] = arr1[i++];
            }
            else{
                nums[ind++] = arr2[j++];
            }
        }

        if(i < m){
            while(i < m){
                nums[ind++] = arr1[i++];
            }
        }
        if(j < n){
            while(j < n){
                nums[ind++] = arr2[j++];
            }
        }

        return nums;
    }
}
