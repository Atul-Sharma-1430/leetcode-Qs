class Solution {
    boolean searchMatrix(int[][] matrix, int target) {

        // Optimal : Ye Ladder Binary Search / Staircase Search approach.
        // TC : O(n + m)
        // SC : O(1)
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {

            // agar curr elem target se equal hai toh return true
            if (matrix[row][col] == target) {
                return true;
            }
            // agar curr value > hai toh col-- bcz us col me uske niche sab values target se badi ho hongi
            else if (matrix[row][col] > target) {
                col--;
            }
            // agar curr value < hai toh row++ bcz us row me uske aage, piche sab values target se choti ho hongi
            else {
                row++;
            }
        }

        return false;






        // Better
        // Solution 2 : Har row ko one by one check karenge
        // for (int i = 0; i < matrix.length; i++) {

        //     int left = 0;
        //     int right = matrix[i].length - 1;

        //     // Current row par Binary Search lagayenge
        //     while (left <= right) {

        //         int mid = left + (right - left) / 2;

        //         if (matrix[i][mid] == target) {
        //             return true;
        //         } else if (matrix[i][mid] < target) {
        //             left = mid + 1;
        //         } else {
        //             right = mid - 1;
        //         }
        //     }
        // }

        // return false;






        // Brute 
        // Solution 1 : Nested Loop Traversal
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[i].length; j++) {
        //         if (matrix[i][j] == target) {
        //             return true;
        //         }
        //     }
        // }

        // return false;
    }
}