package EasyLeetcode;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class HappyNum {

    // Brute Force
    // TC = O(log n), SC = O(log n)
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        if (atul(n, set) == 0) {
            return false;
        } else {
            return true;
        }
    }

    public int atul(int num, Set<Integer> set) {
        int cpy = num;
        if (cpy == 1) return 1;

        int val = 0;
        while (cpy != 0) {
            int last = cpy % 10;
            val += Math.pow(last, 2);
            cpy /= 10;
        }

        if (set.contains(num)) {
            return 0;
        } else {
            set.add(num);
            return atul(val, set);
        }
    }

    // Optimal
    // TC = O(log n), SC = O(1)
    private int getSumOptimal(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappyOptimal(int n) {

        int slow = n;
        int fast = n;

        do {
            slow = getSumOptimal(slow);
            fast = getSumOptimal(getSumOptimal(fast));
        } while (slow != fast);

        return slow == 1;
    }

    public static void main(String[] args) {
        HappyNum solution = new HappyNum();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number: ");
        int n = sc.nextInt();

        boolean result = solution.isHappy(n);
        System.out.println(n + " is a happy number? " + result);

        sc.close();
    }
}
