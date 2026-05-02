package EasyLeetcode;
import java.util.Arrays;

class MergeSortedArray {

    // Brute Force
    // TC = O(m + n), SC = O(m + n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        int[] sortedArray = new int[nums1.length];
        int pointer1 = 0, pointer2 = 0;
        int i;

        for (i = 0; i < sortedArray.length && (pointer1 < m && pointer2 < nums2.length); i++) {
            if (nums1[pointer1] < nums2[pointer2]) {
                sortedArray[i] = nums1[pointer1];
                pointer1++;
            } else {
                sortedArray[i] = nums2[pointer2];
                pointer2++;
            }
        }

        for (int j = i; j < sortedArray.length; j++) {
            if (pointer1 < m) {
                sortedArray[j] = nums1[pointer1];
                pointer1++;
            } else if (pointer2 < nums2.length) {
                sortedArray[j] = nums2[pointer2];
                pointer2++;
            }
        }

        for (int j = 0; j < nums1.length; j++) {
            nums1[j] = sortedArray[j];
        }
    }

    // Optimal
    // TC = O(m + n), SC = O(1)
    public void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        System.out.println("Before merge: " + Arrays.toString(nums1));
        solution.merge(nums1, m, nums2, n);
        System.out.println("After merge:  " + Arrays.toString(nums1));
    }
}
