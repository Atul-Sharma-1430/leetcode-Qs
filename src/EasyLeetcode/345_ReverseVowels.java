package EasyLeetcode;
import java.util.Scanner;

class ReverseVowels {
    public static String reverseVowels(String s) {

        String vowels = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder(s);

        int left = 0;
        int right = sb.length() - 1;

        while (left < right) {
            while (left < right && vowels.indexOf(sb.charAt(left)) == -1) {
                left++;
            }
            while (left < right && vowels.indexOf(sb.charAt(right)) == -1) {
                right--;
            }

            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);

            left++;
            right--;
        }

        return sb.toString();
    }

    // Time Complexity  : O(n)
    // Space Complexity : O(n)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        String result = reverseVowels(s);
        System.out.println("After reversing vowels: " + result);

        sc.close();
    }
}
