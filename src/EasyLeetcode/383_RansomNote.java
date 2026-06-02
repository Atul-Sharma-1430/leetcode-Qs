package EasyLeetcode;

import java.util.*;


class RansomNote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ransomNote: ");
        String ransomNote = sc.next();

        System.out.print("Enter magazine: ");
        String magazine = sc.next();

        System.out.println("Can construct ransomNote? " + canConstruct(ransomNote, magazine));

        sc.close();
    }

    // TC = O(n+m)
    // SC = O(1)
    static public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            int idx = magazine.charAt(i) - 'a';
            freq[idx]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int idx = ransomNote.charAt(i) - 'a';

            if (freq[idx] == 0) {
                return false;
            }
            freq[idx]--;
        }

        return true;
    }
}
