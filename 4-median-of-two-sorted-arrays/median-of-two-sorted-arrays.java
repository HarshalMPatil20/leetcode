class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int finalLength = nums1.length + nums2.length;

        int index2 = finalLength / 2;
        int idx2 = 0;
        int idx1 = 0;

        int index1 = index2 - 1;

        int ptr1 = 0;

        int ptr2 = 0;

        int count = 0;

        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            if (nums1[ptr1] >= nums2[ptr2]) {
                if (count == index1)
                    idx1 = nums2[ptr2];
                if (count == index2)
                    idx2 = nums2[ptr2];
                ptr2++;
                count++;

            } else {
                if (count == index1)
                    idx1 = nums1[ptr1];
                if (count == index2)
                    idx2 = nums1[ptr1];
                ptr1++;
                count++;

            }
        }

        while (ptr1 < nums1.length) {
            
            if (count == index1)
                idx1 = nums1[ptr1];
            if (count == index2)
                idx2 = nums1[ptr1];

            ptr1++;
            count++;
        }

        while (ptr2 < nums2.length) {
            
            if (count == index1)
                idx1 = nums2[ptr2];
            if (count == index2)
                idx2 = nums2[ptr2];

            ptr2++;
            count++;
        }

        if(finalLength%2==1) return (double) idx2;
        else{
            return (double)(idx1+idx2)/2;
        }

    }
}