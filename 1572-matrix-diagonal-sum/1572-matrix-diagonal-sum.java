class Solution {
    public int diagonalSum(int[][] mat) {

        int row = 0;
        int col = 0;

        int sum = 0;

        // Primary diagonal ke elements add karenge [0][0], [1][1], [2][2]...
        while (row < mat.length) {
            sum += mat[row++][col++];
        }

        // Secondary diagonal ke liye Top-right se bottom-left jayenge
        row = 0;
        col = mat[0].length - 1;

        while (row < mat.length && col >= 0) {
            sum += mat[row++][col--];
        }

        // Odd size matrix me center element dono diagonals me count ho gaya hai,
        // isliye ek baar subtract karenge
        if (mat.length % 2 == 1) {
            return sum - mat[mat.length / 2][mat.length / 2];
        }

        return sum;
    }
}