package EasyLeetcode;

import java.util.Scanner;

class RotatedStringContains {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Main String: ");
        String mainStr = sc.next().toLowerCase();

        System.out.print("Enter the Rotates String: ");
        String rString = sc.next().toLowerCase();

        if (rotateString(mainStr, rString)) {
            System.out.println(rString + " can be formed after rotating " + mainStr);
        } else {
            System.out.println(rString + " cannot be formed after rotating " + mainStr);
        }

        sc.close();
    }

    // TC: O(n)
    // SC: O(n)
    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        return (s + s).contains(goal);
    }
}
