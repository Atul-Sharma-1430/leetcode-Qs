package EasyLeetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class KeyboardRow {
    // TC : O(n * m)
    // SC :O(k)
    public static String[] findWords(String[] words) {
        List<String> ansArray = new ArrayList<>();

        String row1 = "qwertyuiopQWERTYUIOP";
        String row2 = "asdfghjklASDFGHJKL";
        String row3 = "zxcvbnmZXCVBNM";

        // Check for each Word
        for (int i = 0; i < words.length; i++) {
            String val = words[i];

            // First character kis row me hai, us row ko store karo
            int row = 0;

            if (row1.indexOf(val.charAt(0)) != -1) {
                row = 1;
            } else if (row2.indexOf(val.charAt(0)) != -1) {
                row = 2;
            } else {
                row = 3;
            }

            boolean valid = true;

            // Check karo ki saare characters same row me hi hain ya nahi
            for (int j = 0; j < val.length(); j++) {

                if (row == 1 && row1.indexOf(val.charAt(j)) == -1) {
                    valid = false;
                    break;
                }

                if (row == 2 && row2.indexOf(val.charAt(j)) == -1) {
                    valid = false;
                    break;
                }

                if (row == 3 && row3.indexOf(val.charAt(j)) == -1) {
                    valid = false;
                    break;
                }
            }

            // Agar valid hai to answer list me add kar do
            if (valid) {
                ansArray.add(val);
            }
        }

        return ansArray.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] words = new String[n];

        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }

        System.out.println("Words that can be typed using one keyboard row: " + Arrays.toString(findWords(words)) );

        sc.close();
    }
}