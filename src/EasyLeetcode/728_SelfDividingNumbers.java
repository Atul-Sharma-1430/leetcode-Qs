package EasyLeetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SelfDividingNumbers {

    // TC: O((right - left + 1) × d)
    // SC : O(k) ==> to return the ans
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            int curr = i;
            boolean sdn = true;

            while (curr != 0) {
                int rem = curr % 10;

                // If digit is 0, it cannot be a self-dividing number
                if (rem == 0) {
                    sdn = false;
                    break;
                }

                // If current digit does not divide the number
                if (i % rem != 0) {
                    sdn = false;
                    break;
                }

                curr /= 10;
            }

            if (sdn) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter left: ");
        int left = sc.nextInt();

        System.out.print("Enter right: ");
        int right = sc.nextInt();

        List<Integer> result = selfDividingNumbers(left, right);

        System.out.println("Self Dividing Numbers:");
        System.out.println(result);

        sc.close();
    }
}