class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;

        for (int i = 0; i < arr1.length; i++) {
            int low = 0;
            int high = arr2.length - 1;
            boolean flag = true;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (Math.abs(arr1[i] - arr2[mid]) <= d) {
                    flag = false;
                    break;
                } else if (arr2[mid] < arr1[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (flag) {
                count++;
            }
        }

        return count;

       
       
       
       
       
       
       
       
       
        // Arrays.sort(arr1);
        // Arrays.sort(arr2);

        // int count = 0;

        // int i = 0;
        // while (i < arr1.length) {
        //     int j = 0;

        //     while (j < arr2.length && Math.abs(arr1[i] - arr2[j]) > d) {
        //         j++;
        //     }

        //     if (j == arr2.length) {
        //         count++;
        //     }

        //     i++;
        // }

        // return count;
    }
}