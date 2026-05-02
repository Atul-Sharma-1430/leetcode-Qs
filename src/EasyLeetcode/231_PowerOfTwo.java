package EasyLeetcode;

import java.util.Scanner;

class PowerOfTwo {
    // TC = O(log n), SC = O(1)
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) {  
            n /= 2;
        }
        return n == 1;        
    }

    // TC = O(1), SC = O(1)
    public static boolean isPowerOfTwoOptimal(int n) {
        return (n > 0 && (n & (n-1)) == 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        if (isPowerOfTwo(num)) {
            System.out.println(num + " is a power of two.");
        } else {
            System.out.println(num + " is NOT a power of two.");
        }

        sc.close();
    }
}
