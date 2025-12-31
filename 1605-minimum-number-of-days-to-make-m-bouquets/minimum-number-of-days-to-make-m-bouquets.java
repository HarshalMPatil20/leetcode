class Solution {
    public int calculateBouquets(int[] bloomDay, int day, int k) {
        int Bouquets = 0;
        int flowers = 0;

        for (int i = 0; i < bloomDay.length; i++) {

            if (bloomDay[i] <= day)
                flowers++;
            else {
                flowers = 0;
            }

            if (flowers == k) {
                flowers = 0;
                Bouquets++;
            }

        }

        return Bouquets;

    }

    public int[] getMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int x : arr) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return new int[] { min, max };
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length)
            return -1;

        int[] arr = getMinMax(bloomDay);

        int low = arr[0];
        int high = arr[1];

        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int Bouquets = calculateBouquets(bloomDay, mid, k);

            if (m <= Bouquets) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;

    }
}