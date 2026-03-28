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
}
