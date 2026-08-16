class Solution {
    public boolean isAnagram(String s, String t) {

        // Solution 1
        // if (s.length() != t.length()) return false;

        // Map<Character, Integer> map1 = new HashMap<>();
        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        //     map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        // }

        // Map<Character, Integer> map2 = new HashMap<>();
        // for (int i = 0; i < t.length(); i++) {
        //     char ch = t.charAt(i);   
        //     map2.put(ch, map2.getOrDefault(ch, 0) + 1); 
        // }

        // return map1.equals(map2);



        // Soln 2
        // if (s.length() != t.length()) return false;

        // char[] arr1 = s.toCharArray();
        // char[] arr2 = t.toCharArray();

        // Arrays.sort(arr1);
        // Arrays.sort(arr2);

        // s = new String(arr1);
        // t = new String(arr2);

        // return s.equals(t);




        // Soln 3
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            // s ke character ki frequency increase
            freq[s.charAt(i) - 'a']++;

            // same time pe t ke character ki frequency bhi decrease
            freq[t.charAt(i) - 'a']--;
        }

        // Agar sabki frequency 0 hai toh anagram hai
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
