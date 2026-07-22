package EasyLeetcode;

import java.util.Scanner;

class FindJudge {
    // TC : O(n + t)
    // SC : O(n)
    public static int findJudge(int n, int[][] trust) {

        if (n == 1 && trust.length == 0) {
            return 1;
        }

        int[] freq = new int[n + 1];

        // Count how many people trust each person
        for (int i = 0; i < trust.length; i++) {
            freq[trust[i][1]]++;
        }

        int judge = 0;

        // Find person trusted by all other than judge
        for (int i = 1; i <= n; i++) {
            if (freq[i] == n - 1) {
                judge = i;
                break;
            }
        }

        if (judge == 0) {
            return -1;
        }

        // Judge should not trust anyone
        for (int i = 0; i < trust.length; i++) {
            if (trust[i][0] == judge) {
                return -1;
            }
        }

        return judge;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        System.out.print("Enter number of trust relationships: ");
        int t = sc.nextInt();

        int[][] trust = new int[t][2];

        System.out.println("Enter trust pairs:");

        for (int i = 0; i < t; i++) {
            trust[i][0] = sc.nextInt();
            trust[i][1] = sc.nextInt();
        }

        int ans = findJudge(n, trust);

        System.out.println("Town Judge: " + ans);

        sc.close();
    }
}
