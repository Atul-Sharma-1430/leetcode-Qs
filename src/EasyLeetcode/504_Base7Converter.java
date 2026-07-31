package EasyLeetcode;
import java.util.Scanner;

class Base7Converter {
    // TC: O(log₇ n)
    // SC: O(log₇ n)
    public static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = Math.abs(num);
        }

        StringBuilder ans = new StringBuilder();
        while (num != 0) {
            ans.append(num % 7);
            num /= 7;
        }

        // Reverse because digits were added from last to first
        ans.reverse();

        // Add '-' at the beginning if the original number was negative
        if (isNegative) {
            ans.insert(0, '-');
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int num = sc.nextInt();

        System.out.println("Base 7 Representation: " + convertToBase7(num));

        sc.close();
    }
}