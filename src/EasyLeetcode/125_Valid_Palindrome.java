package EasyLeetcode;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        if (isPalindrome(sc.nextLine())) {
            System.out.println("Palindrome String");
        } else {
            System.out.println("Not a palindrome String");
        }
        sc.close();
    }

    // Not Optimal
    // TC = O(n), SC = O(n)
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        System.out.println("Processed String: " + sb);

        boolean isPalindrome = true;
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - i - 1)) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }

    // Optimal
    // TC = O(n), SC = O(1)
    public boolean isPalindromeOptimal(String s) {

        int left = 0, right = s.length() - 1;
        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) !=
                    Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
