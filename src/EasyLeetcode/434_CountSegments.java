package EasyLeetcode;

import java.util.Scanner;

class CountSegments {
    // TC : O(n)
    // SC : O(1)
    public static int countSegments(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // if current char is not a space and prev char is a space means new word starts
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String s = sc.nextLine();

        int result = countSegments(s);

        System.out.println("Number of segments: " + result);

        sc.close();
    }
}