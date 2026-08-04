class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        //sort karo tabhi compare kr payenge
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {

            // current index ki values
            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i + 1;

            // Jab tak overlap ho raha hai merge karte jao
            while (j < intervals.length && intervals[j][0] <= end) {

                // End ko maximum end se update karo taaki next time current wale end se check kare
                end = Math.max(end, intervals[j][1]);
                j++;
            }

            ans.add(Arrays.asList(start, end));
            i = j;
        }

        // list to array
        int[][] result = new int[ans.size()][2];

        for (int k = 0; k < ans.size(); k++) {
            result[k][0] = ans.get(k).get(0);
            result[k][1] = ans.get(k).get(1);
        }

        return result;
    }
}