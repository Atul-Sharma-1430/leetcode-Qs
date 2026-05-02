package EasyLeetcode;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

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
