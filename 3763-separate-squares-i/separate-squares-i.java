class Solution {

    // Returns: (half area) - (area above y)
    public double diffupdown(int[][] arr, double totalArea, double y) {

        double upward = 0.0;

        for (int i = 0; i < arr.length; i++) {
            double bottom = arr[i][1];
            double side = arr[i][2];
            double top = bottom + side;

            if (y <= bottom) {
                // Entire square above the line
                upward += side * side;
            } 
            else if (y < top) {
                // Partially above the line
                double heightAbove = top - y;
                upward += side * heightAbove;
            }
        }

        return (totalArea / 2.0) - upward;
    }

    public double separateSquares(int[][] squares) {

        double totalArea = 0.0;
        for (int i = 0; i < squares.length; i++) {
            totalArea += (double) squares[i][2] * squares[i][2];
        }

        double low = 0.0;
        double high = 1e9;
        double ans = high;

        while (high - low > 1e-6) {
            double mid = low + (high - low) / 2.0;
            double diff = diffupdown(squares, totalArea, mid);

            // diff = half - areaAbove
            if (diff < 0) {
                // areaAbove > half → move line UP
                low = mid;
            } else {
                // valid or areaAbove <= half
                ans = mid;
                high = mid;
            }
        }

        return ans;
    }
}
