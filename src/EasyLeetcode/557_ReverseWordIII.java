package EasyLeetcode;

import java.util.Scanner;

class ReverseWordsInStringIII {
    // TC  :O(n)
    // SC : O(n)
    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();

        int i = 0;
        int temp = 0;

        while (i < s.length()) {

            // Find the end of the current word
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }

            // st j from 1 index previous of i
            int j = i - 1;
            // Reverse the current word
            while (j >= temp) {
                ans.append(s.charAt(j));
                j--;
            }

            // Copy spaces
            while (i < s.length() && s.charAt(i) == ' ') {
                ans.append(' ');
                i++;
            }

            // Update the start index of the next word
            temp = i;
        }

        return ans.toString();
    }

    // TC : O(n)
    // SC : O(n)
    public static String reverseWords2(String s) {
        char[] array = s.toCharArray();

        int i = 0;
        while (i < array.length) {
            int j = i;

            // current word ka end find kro
            while (j < array.length && array[j] != ' ') {
                j++;
            }

            // Reverse kro new pointers bna ke
            int left = i;
            int right = j - 1;

            while (left < right) {
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;

                left++;
                right--;
            }

            // Move to the next word
            i = j + 1;
        }

        return new String(array);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String s = sc.nextLine();

        System.out.println("Method 1: " + reverseWords(s));
        System.out.println("Method 2: " + reverseWords2(s));

        sc.close();
    }
}