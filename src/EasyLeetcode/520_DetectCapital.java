package EasyLeetcode;

import java.util.Scanner;

class DetectCapital {
    // TC : O(n)
    // SC : O(1)
    public static boolean detectCapitalUse(String word) {
        // Single character is always valid
        if (word.length() == 1) {
            return true;
        }

        int category = 0;

        // Decide the category using the first two characters
        for (int i = 0; i < 1; i++) {

            // USA (ALL CAPITAL)
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'
                    && word.charAt(i + 1) >= 'A' && word.charAt(i + 1) <= 'Z') {

                category = 1;
            }

            // leetcode (all small)
            else if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z'
                    && word.charAt(i + 1) >= 'a' && word.charAt(i + 1) <= 'z') {

                category = 2;
            }

            // Google (First capital, rest small)
            else if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'
                    && word.charAt(i + 1) >= 'a' && word.charAt(i + 1) <= 'z') {

                category = 3;
            }

            // Invalid pattern
            else {
                return false;
            }
        }

        // Check the remaining characters
        for (int j = 2; j < word.length(); j++) {

            // All letters must be capital
            if (category == 1 &&
                    (word.charAt(j) < 'A' || word.charAt(j) > 'Z')) {
                return false;
            }

            // All letters must be small
            if (category == 2 &&
                    (word.charAt(j) < 'a' || word.charAt(j) > 'z')) {
                return false;
            }

            // Remaining letters must be small
            if (category == 3 &&
                    (word.charAt(j) < 'a' || word.charAt(j) > 'z')) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = sc.nextLine();

        System.out.println("Result: " + detectCapitalUse(word));

        sc.close();
    }
}
