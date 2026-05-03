package EasyLeetcode;

import java.util.HashMap;
import java.util.Scanner;

class IsomorphicStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        System.out.println("Is Isomorphic: " + isIsomorphic(s, t));
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char val = t.charAt(i);

            if (map.containsKey(key)) {
                if (map.get(key) != val) {
                    return false;
                }
            }
            else if (map.containsValue(val)) {
                return false;
            }
            else {
                map.put(key, val);
            }
        }

        return true;
    }

    // TC: O(n)
    // SC: O(n)
    // Both side Mapping
    public boolean isIsomorphicBetter(String s, String t) {

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map1.containsKey(c1)) {
                if (map1.get(c1) != c2) return false;
            } else {
                map1.put(c1, c2);
            }

            if (map2.containsKey(c2)) {
                if (map2.get(c2) != c1) return false;
            } else {
                map2.put(c2, c1);
            }
        }

        return true;
    }
}
