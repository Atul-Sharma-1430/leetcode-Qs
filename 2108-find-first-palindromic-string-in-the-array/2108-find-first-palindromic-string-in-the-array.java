class Solution {
    public String firstPalindrome(String[] words) {
        // har index pe jaake string ko chck krnge

        for (int i = 0; i < words.length; i++) {
            String s = words[i];

            int left = 0;
            int right = s.length() - 1;

            // check for pallindrome
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left++;
                right--;
            }

            // if pallindrome return it
            if (left >= right) {
                return s;
            }
        }
        
        return "";
    }
}