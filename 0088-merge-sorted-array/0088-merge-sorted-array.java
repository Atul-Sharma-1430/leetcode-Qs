class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {






        // Solution 2
        for(int i=m; i<nums1.length; i++) {
            nums1[i] = nums2[i-m];
        }

        Arrays.sort(nums1);



        //Solution 1

        // if (n == 0)
        //     return;

        // int[] sortedArray = new int[nums1.length];

        // int pointer1 = 0, pointer2 = 0;
        // int i;
        // for (i = 0; i < sortedArray.length && (pointer1 < m && pointer2 < nums2.length); i++) {
        //     if (nums1[pointer1] < nums2[pointer2]) {
        //         sortedArray[i] = nums1[pointer1];
        //         pointer1++;
        //     } else {
        //         sortedArray[i] = nums2[pointer2];
        //         pointer2++;
        //     }
        // }

        // for (int j = i; j < sortedArray.length; j++) {
        //     if (pointer1 != m) {
        //         sortedArray[j] = nums1[pointer1];
        //         pointer1++;
        //     }
        //     if (pointer2 != nums2.length) {
        //         sortedArray[j] = nums2[pointer2];
        //         pointer2++;
        //     }
        // }

        // int index = 0;
        // for (int j : sortedArray) {
        //     nums1[index] = j;
        //     index++;
        // }
    }

}