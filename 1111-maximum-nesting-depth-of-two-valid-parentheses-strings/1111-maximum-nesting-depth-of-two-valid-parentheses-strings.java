class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] group = new int[seq.length()];

        // to trck nesting dept
        int depth = 0;

        for (int i = 0; i < seq.length(); i++) {
            char ch = seq.charAt(i);

            // opening bracket means depth increases
            if (ch == '(') {
                depth++;
                group[i] = depth % 2;
            }

            // closing bracket means deoth decreases
            else {
                group[i] = depth % 2;

                depth--;
            }
        }

        return group;
    }
}