package EasyLeetcode;
import java.util.Scanner;

// TC = O(d), SC = O(1)
class ConcateAndMultiply {

    public long sumAndMultiply(int n) {
        long x = 0;    
        long sum = 0;   

        if (n == 0) return 0;

        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            if (digit == 0) continue;
            x = x * 10 + digit;
            sum += digit;
        }

        long rev = 0, temp = x;
        while (temp > 0) {
            rev = rev * 10 + (temp % 10);
            temp /= 10;
        }

        return rev * sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        ConcateAndMultiply obj = new ConcateAndMultiply();
        long result = obj.sumAndMultiply(n);

        System.out.println("Result: " + result);

        sc.close();
    }
}
