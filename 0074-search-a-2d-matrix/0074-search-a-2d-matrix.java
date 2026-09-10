class Solution {

    // Solution 2 : Treating 2d array as 1d array and applying BS
    public boolean searchMatrix(int[][] matrix, int target) {

        int left = 0; // points to [0][0]
        int right = matrix.length * matrix[0].length - 1; // points to [m-1][n-1]

        while (left <= right) {

            int mid = left + (right - left) / 2; // calculating normal mid index

            // finding 2d matrix index using mid
            int row = mid / matrix[0].length; // row = index / no. of columns
            int col = mid % matrix[0].length; // col = index % no. of columns

            // normal BS operations
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    // Solution 1 : Applyting BS on individual rows
    
    // But this is not accepted on leetcode bc of Restriction
    // Line 26: The solution performs a linear scan of the rows, resulting in O(m log n) time complexity.
    // public static boolean bs(int[] array, int target) {

    //     int left = 0;
    //     int right = array.length - 1;

    //     while (left <= right) {
    //         int mid = left + (right - left) / 2;

    //         if (array[mid] == target) {
    //             return true;
    //         } else if (array[mid] < target) {
    //             left = mid + 1;
    //         } else {
    //             right = mid - 1;
    //         }
    //     }

    //     return false;
    // }

    // public boolean searchMatrix(int[][] matrix, int target) {

    //     for (int i = 0; i < matrix.length; i++) {
    //         if (bs(matrix[i], target)) {
    //             return true;
    //         }
    //     }

    //     return false;
    // }
}