class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1;
        int[] b = nums2;
        if(a.length>b.length) return findMedianSortedArrays(b,a);

        int low = 0;
        int high = a.length;

        while(low<=high){

            int part1 = low+(high-low)/2;
            int part2 = (a.length+b.length+1)/2-part1;

            int l1 = (part1==0)?Integer.MIN_VALUE:a[part1-1];
            int l2 = (part2==0)?Integer.MIN_VALUE:b[part2-1];
            int r1 = (part1==a.length)?Integer.MAX_VALUE:a[part1];
            int r2 = (part2==b.length)?Integer.MAX_VALUE:b[part2];

            if(l1<=r2 && l2<=r1){
                if((a.length+b.length)%2==1){
                    return (double)Math.max(l1,l2);
                }
                else{
                    return ((double)(Math.max(l1,l2)+Math.min(r1,r2))/2);
                }
            }
            else if(l1>r2){
                high = part1-1;
            }
            else{
                low = part1+1;
            } 

        }

        return 0.0;
        
    }
}