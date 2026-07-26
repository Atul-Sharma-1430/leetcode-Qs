package EasyLeetcode;

import java.util.Scanner;

class MaxProdOfTwoDigit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        System.out.println("Product of max two digits is : " + maxProduct(num));

        sc.close();
    }

    public static int maxProduct(int n) {

        int largest = Integer.MIN_VALUE;
        int slargest = Integer.MIN_VALUE;

        while (n != 0) {
            int last = n % 10;

            if (last > largest) {
                slargest = largest;
                largest = last;
            } else if (last > slargest) {
                slargest = last;
            }

            n /= 10;
        }

        return largest * slargest;
    }
}