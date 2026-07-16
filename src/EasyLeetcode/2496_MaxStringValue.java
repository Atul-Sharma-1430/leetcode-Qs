package EasyLeetcode;

import java.util.Scanner;

class MaxStringValue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of strings: ");
        int n = sc.nextInt();

        String[] array = new String[n];

        System.out.print("Enter " + n + " strings: ");
        for (int i = 0; i < n; i++) {
            array[i] = sc.next();
        }

        System.out.println("Maximum Value: " + solution(array));

        sc.close();
    }


    //  Time Complexity: O(N * M)
    //  Space Complexity: O(1)
    //  N = Number of strings in the array
    //  M = Average length of each string
    public static int solution(String[] array) {

        int maxVal = 0;
        for (String str : array) {
            // Check whether the string contains any alphabet character
            boolean hasAlphabet = str.matches(".*[a-zA-Z].*");

            if (hasAlphabet) {
                // For alphanumeric strings, value is the length of the string
                maxVal = Math.max(maxVal, str.length());
            } else {
                // For numeric strings, value is the integer value
                maxVal = Math.max(maxVal, Integer.parseInt(str));
            }
        }

        return maxVal;
    }
}

