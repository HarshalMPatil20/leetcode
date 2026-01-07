class Solution {
    public int minLength(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        long distinctSum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];

            // add right element
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            if (freq.get(val) == 1) {
                distinctSum += val;
            }

            // try shrinking
            while (distinctSum >= k) {
                ans = Math.min(ans, right - left + 1);

                int leftVal = nums[left];
                freq.put(leftVal, freq.get(leftVal) - 1);
                if (freq.get(leftVal) == 0) {
                    distinctSum -= leftVal;
                }
                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}