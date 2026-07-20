package EasyLeetcode;

import java.util.Scanner;

class ToLowerCase {
    public static String toLowerCase(String s) {

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int ascii = (int) s.charAt(i);

            if (ascii >= 65 && ascii <= 90) {
                ans.append((char) (ascii + 32));
            } else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }

    // TC : O(n)
    // SC : O(n)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        String result = toLowerCase(s);
        System.out.println("Lowercase String: " + result);

        sc.close();
    }
}