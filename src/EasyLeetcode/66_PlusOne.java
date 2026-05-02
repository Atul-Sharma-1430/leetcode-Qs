package EasyLeetcode;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

// Brute Force
// TC = O(n), SC = O(n)
class PlusOne {
    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int num : digits) {
            sb.append(num);
        }
        String str = sb.toString();
        BigInteger number = new BigInteger(str);
        number = number.add(BigInteger.ONE);
        String newStr = number.toString();

        int[] result = new int[newStr.length()];
        for (int i = 0; i < newStr.length(); i++) {
            result[i] = newStr.charAt(i) - '0';
        }

        return result;
    }

    // Optimal
    // TC = O(n), SC = O(1)
    public int[] plusOneOptimal(int[] digits) {

        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[n + 1];
        result[0] = 1;

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of digits: ");
        int n = sc.nextInt();
        int[] digits = new int[n];

        System.out.println("Enter the digits one by one:");
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }

        PlusOne solution = new PlusOne();
        int[] result = solution.plusOne(digits);

        System.out.println("Result after adding one: " + Arrays.toString(result));

        sc.close();
    }
}
