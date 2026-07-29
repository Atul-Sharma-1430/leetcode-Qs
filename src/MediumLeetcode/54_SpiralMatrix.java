package MediumLeetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SpiralMatrix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];

        System.out.println("Enter the matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        List<Integer> ans = printSpiral(matrix);

        System.out.println("Spiral Order:");
        for (int num : ans) {
            System.out.print(num + " ");
        }

        sc.close();
    }

    // TC: O(n * m)
    // SC: O(1) Auxiliary Space as we just use list to return ans
    public static List<Integer> printSpiral(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0;
        int right = m - 1;
        int bottom = n - 1;
        int left = 0;

        List<Integer> ans = new ArrayList<>();

        while (top <= bottom && left <= right) {

            // Top Row
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }

            // Right Column
            for (int i = top + 1; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }

            // Bottom Row
            if (top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
            }

            // Left Column
            if (left < right) {
                for (int i = bottom - 1; i > top; i--) {
                    ans.add(matrix[i][left]);
                }
            }

            top++;
            bottom--;
            left++;
            right--;
        }

        return ans;
    }
}