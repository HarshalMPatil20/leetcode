class Solution {
    public long[] maxAndSum(int[] arr) {
        long maxi = arr[0];
        long sum = 0;

        for (int x : arr) {
            sum += x;
            maxi = Math.max(x, maxi);
        }

        return new long[] { maxi, sum };
    }

    public int calculateSplits(int[] arr, long capacity) {
        int splits = 1;
        int curr = 0;
        for (int x : arr) {
            if ((long) curr + x > capacity) {
                splits++;
                curr = x;
            } else {
                curr += x;
            }
        }
        return splits;
    }

    public int splitArray(int[] nums, int k) {

        long[] arr = maxAndSum(nums);

        if (k == nums.length)
            return (int) arr[0];
        if (k == 1)
            return (int) arr[1];

        long low = arr[0];
        long high = arr[1];
        long ans = 0; // important

        while (low <= high) {
            long mid = low + (high - low) / 2;
            int splits = calculateSplits(nums, mid);

            if (splits <= k) {
                ans = mid; // update on VALID
                high = mid - 1; // try smaller answer
            } else {
                low = mid + 1; // capacity too small
            }
        }

        return (int) ans;

    }
}