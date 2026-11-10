class Solution {
    public int climbStairs(int n, int[] costs) {
        // st pt
        int prev1 = 0;
        // next step
        int prev2 = Integer.MAX_VALUE;
        // next to next step
        int prev3 = Integer.MAX_VALUE;

        // Step 1 se lekar step n tak har step par minimum cost calculate karenge
        for (int i = 1; i <= n; i++) {

            // Current step tak pahunchne ke liye initially minimum cost infinity maan rahe hain
            int current = Integer.MAX_VALUE;

            // Previous step i-1 se current step par jump karna h yoh
            // Jump distance 1 hai isliye extra cost 1
            if (prev1 != Integer.MAX_VALUE)
                current = Math.min(current, prev1 + costs[i - 1] + (int) Math.pow(2, 0));

            // 2 steps peeche i-2 se current step par jump karna
            // Jump distance 2 hai isliye extra cost 4
            if (prev2 != Integer.MAX_VALUE)
                current = Math.min(current, prev2 + costs[i - 1] + (int) Math.pow(2, 2));

            // 3 steps peeche i-3 se current step par jump karna
            // Jump distance 3 hai isliye extra cost 9
            if (prev3 != Integer.MAX_VALUE)
                current = Math.min(current, prev3 + costs[i - 1] + (int) Math.pow(3, 2));

            // Ab next iteration ke liye previous steps ki values shift kar dnge
            prev3 = prev2;
            prev2 = prev1;
            prev1 = current;
        }

        // Step n tak pahunchne ka minimum total cost return karenge
        return prev1;
    }
}
