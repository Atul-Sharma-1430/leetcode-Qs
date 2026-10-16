class Solution {
    // TC: O(nlog n)
    // SC: O(n)
    static final long MOD = 1000000007L;

    class SegmentTree {
        long[] sum;// Har segment ke distinct counts ka sum store karega
        long[] sumSquares; // Har segment ke distinct counts ke squares ka sum store karega
        long[] lazy; // Range update ko baad mein children par apply karne ke liye pending updates store karega
        int n;// Original array ki length store karega

        SegmentTree(int n) {
            this.n = n;
            // Har segment ke distinct counts ka sum store karega
            sum = new long[4 * n];
            // Har segment ke distinct counts ke squares ka sum store karega
            sumSquares = new long[4 * n];
            // Range update ko baad mein children par apply karne ke liye
            lazy = new long[4 * n];
        }

        public void push(int node, int start, int end) {
            // Agar koi pending update nahi hai toh return kar do
            if (lazy[node] == 0) {
                return;
            }

            long val = lazy[node];
            long len = end - start + 1L;

            // Har value mein val add ho raha hai
            // (x + val)^2 = x^2 + 2*x*val + val^2
            // Isliye squares ka sum formula se update hoga
            sumSquares[node] = (sumSquares[node] + 2L * val % MOD * sum[node] % MOD + val * val % MOD * len % MOD)
                    % MOD;

            // Har value mein val add hone se total sum mein val * len add hoga
            sum[node] = (sum[node] + val * len % MOD) % MOD;

            // Agar leaf node nahi hai toh update children ke liye pending rakho
            if (start != end) {
                lazy[node * 2] += val;
                lazy[node * 2 + 1] += val;
            }

            // Current node ka pending update apply ho gaya
            lazy[node] = 0;
        }

        public void update(int node, int start, int end, int left, int right) {
            // Pehle current node ka pending update apply karo
            push(node, start, end);

            // Agar current segment requested range ke bahar hai
            if (start > right || end < left) {
                return;
            }

            // Agar current segment poori tarah requested range mein hai
            if (start >= left && end <= right) {
                // Is segment ke sabhi distinct counts mein 1 add karna hai
                lazy[node] += 1;
                // Update ko current node par apply kar do
                push(node, start, end);
                return;
            }

            // Current segment ko left aur right parts mein divide karo
            int mid = start + (end - start) / 2;

            update(node * 2, start, mid, left, right);
            update(node * 2 + 1, mid + 1, end, left, right);

            // Dono children ke results se parent ka sum update karo
            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
            // Dono children ke squared sums se parent update karo
            sumSquares[node] = (sumSquares[node * 2] + sumSquares[node * 2 + 1]) % MOD;
        }

        public void update(int left, int right) {
            // Valid range hone par hi update call karo
            if (left <= right) {
                update(1, 0, n - 1, left, right);
            }
        }

        long getSumSquares() {
            // Root mein poori range ke squared counts ka sum hai
            return sumSquares[1];
        }
    }

    public int sumCounts(int[] nums) {

        int n = nums.length;

        // Sabhi starting indices ke distinct counts maintain karne ke liye
        SegmentTree tree = new SegmentTree(n);
        // Har element ka latest occurrence index store karega
        HashMap<Integer, Integer> lastIndex = new HashMap<>();

        long ans = 0;
        // Har index ko current subarray ka ending index maan kar process karo
        for (int j = 0; j < n; j++) {
            // Current element ka previous occurrence Agar pehle nahi aaya toh -1 milega
            int prev = lastIndex.getOrDefault(nums[j], -1);

            // Previous occurrence ke baad se j tak ke starting indices ke subarrays mein current element naya distinct element hai
            tree.update(prev + 1, j);

            // Current ending index par end hone wale sabhi subarrays ke squared distinct counts ka sum answer mein add karo
            ans = (ans + tree.getSumSquares()) % MOD;
            
            // Current element ka latest occurrence update karo
            lastIndex.put(nums[j], j);
        }

        return (int) ans;




















        // 37 / 542 testcases passed
        // Set<Integer> combo = new HashSet<>();
        // long ans = 0;
        // int mod = 1000000007; // to avoid intgr ovrflow

        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i; j < nums.length; j++) {
        //         combo.add(nums[j]);
        //         ans = (ans + (long)( combo.size() * combo.size())) % mod; // agar bda num hua toh uska modulas
        //     }
        //     combo.clear();
        // }

        // return (int) ans;
    }
}