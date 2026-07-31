package EasyLeetcode;

import java.util.*;

class MinimumPushes {
    // TC: O(n)
    // SC: O(n)
    public static int minimumPushesBrute(String word) {
        // Map to store ki kaunsa character kisse map ho rha h
        Map<Character, Integer> map = new HashMap<>();

        int mapNum = 1;
        for (int i = 0; i < word.length(); i++) {
            // har char ko uske mapping num ke saath map me rakho
            map.put(word.charAt(i), mapNum);

            // Agar 8 characters ho gye toh count ko increase kr do
            if ((i + 1) % 8 == 0) {
                mapNum++;
            }
        }

        int press = 0;
        for (int i = 0; i < word.length(); i++) {
            press += map.get(word.charAt(i));
        }

        return press;
    }

    // TC: O(n)
    // SC: O(1)
    public static int minimumPushesOptimal(String word) {

        int press = 0; // stores final ans
        int count = 0; // count manage krta hai agar 8 charcters ka
        int mapNum = 1; // mapping number

        for (int i = 0; i < word.length(); i++) {

            press += mapNum;
            count++;

            // if 8 characters passed then count increase
            if (count % 8 == 0) {
                mapNum++;
            }
        }

        return press;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the word: ");
        String word = sc.next();

        System.out.println("HashMap Approach Answer : " + minimumPushesBrute(word));
        System.out.println("Optimal Approach Answer : " + minimumPushesOptimal(word));

        sc.close();
    }
}