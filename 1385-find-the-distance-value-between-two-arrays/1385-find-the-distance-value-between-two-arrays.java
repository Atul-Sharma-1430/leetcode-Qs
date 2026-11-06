class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int count = 0;

        int i = 0;
        while (i < arr1.length) {
            int j = 0;

            while (j < arr2.length && Math.abs(arr1[i] - arr2[j]) > d) {
                j++;
            }

            if (j == arr2.length) {
                count++;
            }

            i++;
        }

        return count;
    }
}