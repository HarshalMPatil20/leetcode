class Solution {
    public int maxInArray(int[] arr) {
        int maxi = Integer.MIN_VALUE;

        for (int i : arr) {
            maxi = Math.max(maxi, i);
        }

        return maxi;
    }

    public long calculateHours(int[] arr, long speed) {
        long totalHours = 0;

        for (int i : arr) {
            totalHours += (long) Math.ceil((double) i / speed);
        }

        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int h) {

        long low = 1;
        long high = maxInArray(piles);

        long ans = maxInArray(piles);

        long total_hours = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            total_hours = calculateHours(piles, mid);

            if (total_hours <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return (int) ans;

    }
}