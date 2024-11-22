class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int [] ans = new int[nums1.length+nums2.length];
        int i=0;
        int j=0;
        int ptr=0;
        double median;


        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                ans[ptr]=nums1[i];
                ptr++;
                i++;
            }
            else{
                ans[ptr]=nums2[j];
                ptr++;
                j++;
            }
        }
        while(i<nums1.length){
            ans[ptr]=nums1[i];
            ptr++;
            i++;
        }
        while(j<nums2.length){
            ans[ptr]=nums2[j];
            ptr++;
            j++;
        }

        if((nums1.length+nums2.length)%2==0){
            median = ans[(nums1.length+nums2.length)/2] + ans[(nums1.length+nums2.length)/2-1];
            median /=2;
        }
        else{
            median = ans[(nums1.length+nums2.length)/2];
        }

        return median;
    }
}