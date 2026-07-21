package EasyLeetcode;

import java.util.Scanner;
import java.util.Stack;

class ValidParentheses {

    // TC: O(n)
    // SC: O(n)
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.pop();

                    if ((ch == ')' && top != '(') ||
                            (ch == ']' && top != '[') ||
                            (ch == '}' && top != '{')) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        boolean result = isValid(s);

        System.out.println("Valid Parentheses: " + result);

        sc.close();
    }
}