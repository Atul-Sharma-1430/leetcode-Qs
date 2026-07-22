package EasyLeetcode;

import java.util.Scanner;

class MaxWordsFoundInSentences {
    // TC : O(n * m)
    // SC : O(1)
    public static int mostWordsFound(String[] sentences) {

        int max = -1;
        for (int i = 0; i < sentences.length; i++) {
            int count = 1;
            for (int j = 0; j < sentences[i].length(); j++) {
                if (sentences[i].charAt(j) == ' ') {
                    count++;
                }
            }

            if (count > max) {
                max = count;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of sentences: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] sentences = new String[n];

        System.out.println("Enter the sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = sc.nextLine();
        }

        System.out.println("Maximum words in a sentence: " + mostWordsFound(sentences));

        sc.close();
    }
}