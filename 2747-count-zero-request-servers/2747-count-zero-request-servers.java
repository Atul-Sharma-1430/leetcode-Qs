class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int[][] arr = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            arr[i][0] = queries[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[queries.length];

        int left = 0;
        int right = 0;

        for (int i = 0; i < queries.length; i++) {
            int start = arr[i][0] - x;
            int end = arr[i][0];

            // Add all logs whose time is within the ending time
            while (right < logs.length && logs[right][1] <= end) {
                int server = logs[right][0];
                map.put(server, map.getOrDefault(server, 0) + 1);
                right++;
            }

            // Remove logs that are outside the starting time
            while (left < right && logs[left][1] < start) {
                int server = logs[left][0];

                map.put(server, map.get(server) - 1);

                if (map.get(server) == 0) {
                    map.remove(server);
                }

                left++;
            }

            // Count servers that received zero requests
            ans[arr[i][1]] = n - map.size();
        }

        return ans;
    }
}