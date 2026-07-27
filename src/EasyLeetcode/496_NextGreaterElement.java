package EasyLeetcode;

import java.util.Arrays;
import java.util.Scanner;

class NextGreaterElement {
    // TC : O(n2)
    // SC : O(n)
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ansArray = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            // nums2 me current element ka index find karo
            int j = 0;
            while (nums2[j] != nums1[i]) {
                j++;
            }

            // current element ke next index se search start karo
            j++;

            boolean hasGreater = false;
            while (j < nums2.length) {
                // Agar current element bada mil gaya
                if (nums2[j] > nums1[i]) {
                    hasGreater = true;
                    ansArray[i] = nums2[j];
                    break;
                }

                j++;
            }

            // Agar koi greater element nahi mila
            if (!hasGreater) {
                ansArray[i] = -1;
            }
        }

        return ansArray;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of nums1: ");
        int n = sc.nextInt();

        int[] nums1 = new int[n];

        System.out.println("Enter elements of nums1:");
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.print("Enter size of nums2: ");
        int m = sc.nextInt();

        int[] nums2 = new int[m];

        System.out.println("Enter elements of nums2:");
        for (int i = 0; i < m; i++) {
            nums2[i] = sc.nextInt();
        }

        System.out.println("Next Greater Elements: " + Arrays.toString(nextGreaterElement(nums1, nums2)));

        sc.close();
    }
}
