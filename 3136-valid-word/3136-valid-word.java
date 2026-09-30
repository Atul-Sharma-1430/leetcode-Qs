class Solution {
    public boolean isValid(String word) {
        String vowels = "aeiouAEIOU";
        String consonents = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";

        if (word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasCons = false;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (vowels.indexOf(ch) != -1) {
                hasVowel = true;
            }

            if (consonents.indexOf(ch) != -1) {
                hasCons = true;
            }

            if (!((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))) {
                return false;
            }
        }

        if (!hasVowel || !hasCons) {
            return false;
        }

        return true;
    }
}