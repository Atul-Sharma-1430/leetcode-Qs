package EasyLeetcode;

import java.util.Scanner;

class GridSatisfiesCondition {
    public static boolean satisfiesConditions(int[][] grid) {

        // Check horizontally
        for (int i = 0; i < grid[0].length - 1; i++) {
            if (grid[0][i] == grid[0][i + 1]) {
                return false;
            }
        }

        // Check vertically
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != grid[i + 1][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    // TC : O(n2)
    // SC : (1)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];

        System.out.print("Enter the elements of the grid:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        boolean ans = satisfiesConditions(grid);
        System.out.println("Result: " + ans);

        sc.close();
    }
}