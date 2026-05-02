package EasyLeetcode;

import java.util.Scanner;
import java.util.HashMap;

// TC = O(n), SC = O(1)
class RomanToNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter any Roman Number: ");
        String roman = sc.nextLine();

        System.out.println("Integer value: " + romanToInt(roman));

        sc.close();
        
    }

    static int romanToInt(String roman) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;

        for (int i = 0; i < roman.length(); i++) {
            int current = map.get(roman.charAt(i));
            int next = 0;

            if (i + 1 < roman.length()) {
                next = map.get(roman.charAt(i + 1));
            }

            if (current < next) {
                sum -= current;
            } else {
                sum += current;
            }
        }

        return sum;
    }
}
