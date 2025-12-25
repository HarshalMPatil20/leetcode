class Solution {
    public int findPivot(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (nums[mid] > nums[high]) {
                // Pivot is in right half
                low = mid + 1;
            } else {
                // Pivot is in left half (including mid)
                high = mid;
            }
        }
        return low; // index of smallest element
    }

    public int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;

        int pivot = findPivot(nums);

        // If target is in right sorted part
        if (target >= nums[pivot] && target <= nums[n - 1]) {
            return binarySearch(nums, pivot, n - 1, target);
        }
        // Else target is in left sorted part
        else {
            return binarySearch(nums, 0, pivot - 1, target);
        }
    }
}