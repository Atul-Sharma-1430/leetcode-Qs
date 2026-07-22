package EasyLeetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class SetMatrixZeroes {

    // TC : O(m * n)
    // SC : O(m + n)
    public static void setZeroes(int[][] matrix) {

        Set<Integer> set1 = new HashSet<>(); // Store rows having zero
        Set<Integer> set2 = new HashSet<>(); // Store columns having zero

        // Find rows and columns containing zero
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == 0) {
                    set1.add(i);
                    set2.add(j);
                }
            }
        }

        // Set complete row and column to zero
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (set1.contains(i) || set2.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        setZeroes(matrix);
        System.out.println("Matrix after setting zeroes:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}