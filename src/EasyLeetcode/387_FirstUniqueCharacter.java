package EasyLeetcode;

import java.util.HashMap;
import java.util.Scanner;

class FirstUniqueCharacter {
    // TC: O(n²)
    // SC: O(1)
    public static int brute(String s) {

        for (int i = 0; i < s.length(); i++) {
            boolean unique = true;

            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    unique = false;
                    break;
                }
            }

            if (unique) {
                return i;
            }
        }

        return -1;
    }

    // TC: O(n)
    // SC: O(1) (At most 26 lowercase letters)
    public static int better(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    // TC: O(n)
    // SC: O(1)
    public static int optimal(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        System.out.println("Method 1 (Brute Force): " + brute(s));
        System.out.println("Method 2 (HashMap): " + better(s));
        System.out.println("Method 3 (Frequency Array): " + optimal(s));

        sc.close();
    }
}
