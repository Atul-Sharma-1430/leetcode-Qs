package EasyLeetcode;
import java.math.BigInteger;
import java.util.Scanner;

// TC = O(n*m), SC = O(n+m)
class MultiplyStrings {

    public String multiply(String num1, String num2) {
        BigInteger n1 = new BigInteger(num1);
        BigInteger n2 = new BigInteger(num2);

        BigInteger result = n1.multiply(n2);
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        String num1 = sc.nextLine();

        System.out.print("Enter the second number: ");
        String num2 = sc.nextLine();

        MultiplyStrings sol = new MultiplyStrings();
        String product = sol.multiply(num1, num2);

        System.out.println("The product is: " + product);

        sc.close();
    }
}
