package HardLeetCode;

class Solution {
    // TC = O(m + n), SC = O(m + n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sortedArray = new int[nums1.length + nums2.length];
        int pointer1 = 0, pointer2 = 0;
        int i;
        
        for (i = 0; i < sortedArray.length && (pointer1 < nums1.length && pointer2 < nums2.length); i++) {
            if (nums1[pointer1] < nums2[pointer2]) {
                sortedArray[i] = nums1[pointer1];
                pointer1++;
            } else {
                sortedArray[i] = nums2[pointer2];
                pointer2++;
            }
        }

        for (int j = i; j < sortedArray.length; j++) {
            if (pointer1 != nums1.length) {
                sortedArray[j] = nums1[pointer1];
                pointer1++;
            } else if (pointer2 != nums2.length) {
                sortedArray[j] = nums2[pointer2];
                pointer2++;
            }
        }

        int mid = sortedArray.length / 2;

        if (sortedArray.length % 2 != 0) {
            return sortedArray[mid];
        } else {
            return (sortedArray[mid] + sortedArray[mid - 1]) / 2.0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        double median = solution.findMedianSortedArrays(nums1, nums2);

        System.out.println("Median of the two sorted arrays is: " + median);
    }
}
