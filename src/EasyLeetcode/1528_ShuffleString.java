package EasyLeetcode;

import java.util.Scanner;

class ShuffleString {
    // TC : O(n)
    // SC : O(n)
    public static String shuffleString(String s, int[] indices) {
        char[] arr = new char[indices.length];

        int i = 0;
        while (i < s.length()) {
            arr[indices[i]] = s.charAt(i);
            i++;
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.next();

        System.out.print("Enter size of indices array: ");
        int n = sc.nextInt();

        int[] indices = new int[n];

        System.out.println("Enter indices:");
        for (int i = 0; i < n; i++) {
            indices[i] = sc.nextInt();
        }

        System.out.println("Restored String: " + shuffleString(s, indices));

        sc.close();
    }
}