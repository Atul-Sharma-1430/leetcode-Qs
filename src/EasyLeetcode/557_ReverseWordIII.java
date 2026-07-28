package EasyLeetcode;

import java.util.Scanner;

class ReverseWordsInStringIII {
    // TC  :O(n)
    // SC : O(n)
    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();

        int i = 0;
        int temp = 0;

        while (i < s.length()) {

            // Find the end of the current word
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }

            // Reverse the current word
            int j = i - 1;

            while (j >= temp) {
                ans.append(s.charAt(j));
                j--;
            }

            // Copy spaces
            while (i < s.length() && s.charAt(i) == ' ') {
                ans.append(' ');
                i++;
            }

            // Update the start index of the next word
            temp = i;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String s = sc.nextLine();

        System.out.println("Result: " + reverseWords(s));

        sc.close();
    }
}