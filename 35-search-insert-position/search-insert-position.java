class Solution {
    public int Insertin(int[] arr, int low, int high, int target) {
        if (low > high)
            return low;

        int mid = low + (high - low) / 2;

        if (arr[mid] == target)
            return mid;

        else if (arr[mid] > target)
            return Insertin(arr, low, mid - 1, target);
        else
            return Insertin(arr, mid + 1, high, target);

    }

    public int searchInsert(int[] nums, int target) {

        return Insertin(nums, 0, nums.length - 1, target);

    }
}