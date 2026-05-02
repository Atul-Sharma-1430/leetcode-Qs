package EasyLeetcode;
import java.util.*;

class ValidAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String 1: ");
        String str1 = sc.nextLine();

        System.out.print("Enter String 2: ");
        String str2 = sc.nextLine();

        ValidAnagrams vang = new ValidAnagrams();

        if(vang.isAnagram(str1 , str2)) {
            System.out.println("'" + str1 + "' and " + "'" + str2 + "'  are valid anagrams.");
        } else {
            System.out.println("'" + str1 + "' and " + "'" + str2 + "'  are not Valid anagrams.");
        }

        sc.close();
    }

    // Not Optimal
    // TC = O(n), SC = O(n)
    boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        return map1.equals(map2);
    }


    // Optimal
    // TC = O(n), SC = O(1) or O(26)
    public boolean isAnagramOptimal(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
        }

        for (int f : freq) {
            if (f != 0) return false;
        }

        return true;
    }
}
