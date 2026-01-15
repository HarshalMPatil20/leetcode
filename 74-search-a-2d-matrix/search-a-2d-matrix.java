class Solution {
    public int[] searchInColumn(int[][] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int row = high;
        int found = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid][0] == target) {
                found = 1;
                break;
            } else if (arr[mid][0] < target) {
                row = mid;
                low = mid + 1;
            } else {
                
                high = mid - 1;
            }
        }

        return new int[] { found, row };
    }

    public boolean searchInRow(int[][] arr, int row, int target) {
        int low = 0;
        int high = arr[0].length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[row][mid] == target) {
                return true;
            } else if (arr[row][mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int[] columnSearch = searchInColumn(matrix, target);

        if (columnSearch[0] == 1)
            return true;

        return searchInRow(matrix,columnSearch[1],target);

    }
}