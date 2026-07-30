package EasyLeetcode;

import java.util.Scanner;

class IslandPerimeter {
    // TC : O(mn)
    // SC : O(1)
    public static int islandPerimeter(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {

                    // Check Left
                    if (j - 1 < 0) {
                        count++;
                    } else if (grid[i][j - 1] == 0) {
                        count++;
                    }

                    // Check Right
                    if (j + 1 >= grid[i].length) {
                        count++;
                    } else if (grid[i][j + 1] == 0) {
                        count++;
                    }

                    // Check Up
                    if (i - 1 < 0) {
                        count++;
                    } else if (grid[i - 1][j] == 0) {
                        count++;
                    }

                    // Check Down
                    if (i + 1 >= grid.length) {
                        count++;
                    } else if (grid[i + 1][j] == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];

        System.out.println("Enter the grid (0 for water, 1 for land):");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int perimeter = islandPerimeter(grid);

        System.out.println("Island Perimeter = " + perimeter);

        sc.close();
    }
}