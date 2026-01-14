class Solution {

    // Computes total area of square parts ABOVE horizontal line y
    public double areaAbove(int[][] squares, double y) {
        double area = 0.0;

        for (int[] sq : squares) {
            double bottom = sq[1];
            double side = sq[2];
            double top = bottom + side;

            if (y <= bottom) {
                // Entire square is above the line
                area += side * side;
            } 
            else if (y < top) {
                // Partially above the line
                double heightAbove = top - y;
                area += side * heightAbove;
            }
            // else: square completely below → contributes 0
        }

        return area;
    }

    public double separateSquares(int[][] squares) {
        double totalArea = 0.0;

        for (int[] sq : squares) {
            totalArea += (double) sq[2] * sq[2];
        }

        double target = totalArea / 2.0;

        double low = 0.0;
        double high = 1e9;
        double ans = high;

        while (high - low > 1e-6) {
            double mid = low + (high - low) / 2.0;

            double above = areaAbove(squares, mid);

            if (above > target) {
                // Line is too low → too much area above
                low = mid;
            } else {
                // Valid position, try to minimize y
                ans = mid;
                high = mid;
            }
        }

        return ans;
    }
}
