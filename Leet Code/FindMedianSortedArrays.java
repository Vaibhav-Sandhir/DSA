class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int total = n1 + n2;
        int merged[] = new int[total];
        int i = 0;
        int j = 0;
        int ind = 0;
        while(i < n1 || j < n2){
            if(nums1[i] > nums2[j]){
                merged[ind++] = nums2[j];
                j++;
            }

            else if(nums1[i] <= nums2[j] ){
                merged[ind++] = nums1[i];
                i++;
            }
        }
        if(i == n1){
            for(; j < n2; j++){
                merged[ind++] = nums2[j];
            }
        }
        if(j == n2){
            for(; i < n1; i++){
                merged[ind++] = nums1[i];
            }
        }

        if(total % 2 != 0)
            return (double)merged[total / 2];
        else
            return ((double)merged[total / 2] + (double)merged[(total / 2) - 1] / 2);    
    }
}
