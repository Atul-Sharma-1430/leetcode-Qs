package MediumLeetcode;

import java.util.Scanner;

class SingleElemInSortedArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the sorted array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Single Element: " + findSingle(nums));

        sc.close();
    }

    // TC : O(n)
    // SC : O(1)
    public static int findSingleXor(int[] nums) {

        int xorAll = 0;

        for (int num : nums) {
            xorAll ^= num;
        }

        return xorAll;
    }

    // TC : O(log n)
    // SC : O(1)
    public static int findSingle(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;

            // Make mid even so that we always compare a pair.
            // Pair ka first element hamesha even index se hi start hona chahiye.
            if (mid % 2 != 0) {
                mid--;
            }

            // Agar even index aur uske next index ki value same hai,
            // iska matlab abhi tak koi single element nahi aaya.
            // Agar single element pehle aa gaya hota to pairing shift ho jati.
            // Isliye left pointer ko next pair par bhej do.
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            }

            // Agar pair break ho gaya hai,
            // to single element isi pair ke pehle ya mid par hi hoga.
            // Isliye search space ko left side par le aao.
            else {
                right = mid;
            }
        }

        // Left aur right dono same element par aa jayenge.
        return nums[left];
    }
}