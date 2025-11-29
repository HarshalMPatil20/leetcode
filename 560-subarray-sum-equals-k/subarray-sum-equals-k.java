class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> prefixsumcount = new HashMap<>();

        prefixsumcount.put(0,1);

        int prefixsum=0;
        int count=0;

        for(int i=0; i<nums.length;i++){

            prefixsum+=nums[i];

            int remove = prefixsum-k;

            count+=prefixsumcount.getOrDefault(remove,0);

            prefixsumcount.put(prefixsum,prefixsumcount.getOrDefault(prefixsum,0)+1);


        }

        return count;


    }
}