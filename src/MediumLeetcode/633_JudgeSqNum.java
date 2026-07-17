package MediumLeetcode;

import java.util.Scanner;

class JudgeSqNum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the target number: ");
        int target = sc.nextInt();

        if(check(target)) {
            System.out.println("Yes the Number is sum of Square of two number.");
        } else {
            System.out.println("No, the Number is not the sum of Square of two number.");
        }

        sc.close();
    }

    // TC : O(root n)
    // SC : O(1)
    public static boolean check(int target) {
        long left = 0;
        long right = (long)Math.sqrt(target);

        while(left <= right) {
            long val = left*left + right*right;

            if (val == target) {
                return true;
            }
            else if (val > target) {
                // right = (left + right) / 2;
                right--;
            }
            else {
                // left = (left + right) / 2;
                left++;
            }
        }

        return false;
    }
}
