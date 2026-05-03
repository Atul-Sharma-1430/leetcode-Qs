package EasyLeetcode;

import java.util.*;

class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        char[] arr = input.toCharArray();

        reverse(arr);

    }

    // TC: O(n)
    // SC: O(1)
    static void reverse(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }

        System.out.print("Reversed string: ");
        for (char c : s) {
            System.out.print(c);
        }
    }
}