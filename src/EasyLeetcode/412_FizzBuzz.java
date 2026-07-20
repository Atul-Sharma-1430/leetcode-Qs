package EasyLeetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
            }
        }

        return ans;
    }

    // TC : O(n)
    // Sc : O(n)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        List<String> result = fizzBuzz(n);

        System.out.println("FizzBuzz Output:");
        for (String s : result) {
            System.out.println(s);
        }

        sc.close();
    }
}