package EasyLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class PascalsTriangleI {
    // Approach 1 : Using nCr Formula
    // TC: O(numRows²)
    // SC: O(numRows²) (Output Space)
    private static List<Integer> printTriangle(int rowNum) {
        List<Integer> row = new ArrayList<>();

        row.add(1);

        long prev = 1;
        for (int i = 1; i <= rowNum; i++) {
            prev = prev * (rowNum - i + 1) / i;
            row.add((int) prev);
        }

        return row;
    }

    public static List<List<Integer>> generateUsingNCR(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        if (numRows == 0) {
            return ans;
        }

        ans.add(new ArrayList<>(Arrays.asList(1)));

        for (int i = 1; i < numRows; i++) {
            ans.add(printTriangle(i));
        }

        return ans;
    }

    // Approach 2 : Using Previous Row
    // TC: O(numRows²)
    // SC: O(numRows²) (Output Space)
    public static List<List<Integer>> generateUsingPreviousRow(int numRows) {

        if (numRows == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(1)));

        for (int i = 1; i < numRows; i++) {

            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);

            List<Integer> lastRow = triangle.get(triangle.size() - 1);

            for (int j = 1; j < i; j++) {
                currRow.add(lastRow.get(j - 1) + lastRow.get(j));
            }

            currRow.add(1);
            triangle.add(currRow);
        }

        return triangle;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int numRows = sc.nextInt();

        System.out.println("\nUsing nCr Formula:");
        List<List<Integer>> triangle1 = generateUsingNCR(numRows);

        for (List<Integer> row : triangle1) {
            System.out.println(row);
        }

        System.out.println("\nUsing Previous Row:");
        List<List<Integer>> triangle2 = generateUsingPreviousRow(numRows);

        for (List<Integer> row : triangle2) {
            System.out.println(row);
        }

        sc.close();
    }
}