class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String rev = new StringBuilder(words[i]).reverse().toString();

            if (set.contains(rev)) {
                count++;
            } else {
                set.add(words[i]);
            }
        }

        return count;













        // for (int i = 0; i < words.length; i++) {
        //     for (int j = i; j < words.length; j++) {
        //         if (i != j && words[i].equals(new StringBuilder(words[j]).reverse().toString())) {
        //             count++;
        //         }
        //     }
        // }

    }
}