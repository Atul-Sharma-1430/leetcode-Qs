class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length; 
        int n2 = nums2.length;

        int n = n1 + n2; 

        int index2 = n / 2; // Median ka right/second index
        int index1 = index2 - 1; // Median ka left/first index

        int count = 0; // Virtual merged array mein current index track karega

        int elem1 = -1, elem2 = -1; // Median ke 2 required elements store karenge

        int i = 0, j = 0; // i -> nums1, j -> nums2 ko traverse karega

        // Dono arrays mein elements available hain tab tak compare karenge
        while (i < n1 && j < n2) {

            if (nums1[i] < nums2[j]) {

                // Agar current position median ke left index par hai
                if (count == index1) {
                    elem1 = nums1[i]; // Left median element store karo
                }

                // Agar current position median ke right index par hai
                if (count == index2) {
                    elem2 = nums1[i]; // Right median element store karo
                }

                count++; // Virtual merged array ka index increase
                i++; // nums1 mein next element par move
            }

            // nums2 ka current element chhota/equal hai
            else {

                // Agar current position median ke left index par hai
                if (count == index1) {
                    elem1 = nums2[j]; // Left median element store karo
                }

                // Agar current position median ke right index par hai
                if (count == index2) {
                    elem2 = nums2[j]; // Right median element store karo
                }

                count++; // Virtual merged array ka index increase
                j++; // nums2 mein next element par move
            }
        }

        // Agar nums1 mein abhi elements bach gaye hain
        while (i < n1) {

            // Median ke left element ko find karo
            if (count == index1) {
                elem1 = nums1[i];
            }

            // Median ke right element ko find karo
            if (count == index2) {
                elem2 = nums1[i];
            }

            count++; // Next virtual index
            i++; // nums1 ka next element
        }

        // Agar nums2 mein abhi elements bach gaye hain
        while (j < n2) {

            // Median ke left element ko find karo
            if (count == index1) {
                elem1 = nums2[j];
            }

            // Median ke right element ko find karo
            if (count == index2) {
                elem2 = nums2[j];
            }

            count++; // Next virtual index
            j++; // nums2 ka next element
        }

        // Agar total elements odd hain
        if (n % 2 == 1) {
            return elem2; // Sirf middle/right element hi median hoga
        }

        // Agar total elements even hain
        // Median = dono middle elements ka average
        return (double) (elem1 + elem2) / 2.0;







        // BruteForce approach
        // int[] sortedArray = new int[nums1.length + nums2.length];
        // int pointer1 = 0, pointer2 = 0;
        // int i;
        // for (i = 0; i < sortedArray.length && (pointer1 < nums1.length && pointer2 < nums2.length); i++) {
        //     if (nums1[pointer1] < nums2[pointer2]) {
        //         sortedArray[i] = nums1[pointer1];
        //         pointer1++;
        //     } else {
        //         sortedArray[i] = nums2[pointer2];
        //         pointer2++;
        //     }
        // }

        // for (int j = i; j < sortedArray.length; j++) {
        //     if (pointer1 != nums1.length) {
        //         sortedArray[j] = nums1[pointer1];
        //         pointer1++;
        //     }
        //     if (pointer2 != nums2.length) {
        //         sortedArray[j] = nums2[pointer2];
        //         pointer2++;
        //     }
        // }

        // int mid = sortedArray.length / 2;

        // if (sortedArray.length % 2 != 0) {
        //     return sortedArray[mid];
        // } else {
        //     return (sortedArray[mid] + sortedArray[mid - 1]) / 2.00;
        // }
    }
}