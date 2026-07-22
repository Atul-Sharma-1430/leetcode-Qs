package EasyLeetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class WordContainingCharacter {
    // TC : O(n * m)
    // SC : O(k)
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ansArray = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            // indexOf() returns -1 if the character is not present
            if (words[i].indexOf(x) != -1) {
                ansArray.add(i);
            }
        }

        return ansArray;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WordContainingCharacter obj = new WordContainingCharacter();

        System.out.print("Enter number of words: ");
        int n = sc.nextInt();

        String[] words = new String[n];

        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        System.out.print("Enter the character to search: ");
        char x = sc.next().charAt(0);

        List<Integer> ans = obj.findWordsContaining(words, x);

        System.out.println("Indices: " + ans);

        sc.close();
    }
}