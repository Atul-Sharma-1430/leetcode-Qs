class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                if (i != j && words[i].equals(new StringBuilder(words[j]).reverse().toString())) {
                    count++;
                }
            }
        }

        return count;
    }
}