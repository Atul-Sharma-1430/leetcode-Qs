package EasyLeetcode;

import java.util.Scanner;

class PowerOfFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number: ");
        int n = sc.nextInt();

        if(n >=1 && (n & (n-1)) == 0 && (n-1) % 3 == 0) {
            System.out.println("Number is A Power of 4");
        } else {
            System.out.println("Number is Not a Power of 4");
        }
        sc.close();
    }
}
