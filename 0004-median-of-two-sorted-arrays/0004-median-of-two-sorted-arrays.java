class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Binary Search hamesha smaller array par karenge taaki Time Complexity O(log(min(n1, n2))) rahe
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length; // nums1 ki total length
        int n2 = nums2.length; // nums2 ki total length

        int totalLength = n1 + n2; // Dono arrays ko virtually merge karne par total elements

        // Left partition mein total elements ka half rakhna hai, +1 odd case ko handle karne ke liye
        int leftSize = (totalLength + 1) / 2;

        int low = 0; // nums1 ke partition ki minimum possible position
        int high = n1; // nums1 ke partition ki maximum possible position

        while (low <= high) {

            // Binary Search ki help se nums1 mein current partition position find kar rahe hain
            int partition1 = low + (high - low) / 2;

            // Left partition mein total leftSize elements chahiye, isliye baaki nums2 se lenge
            int partition2 = leftSize - partition1;

            int left1; // nums1 ke left partition ka last element
            int right1; // nums1 ke right partition ka first element
            int left2; // nums2 ke left partition ka last element
            int right2; // nums2 ke right partition ka first element

            // Agar nums1 se left partition mein koi element nahi liya toh smallest possible value maanenge
            if (partition1 == 0) {
                left1 = Integer.MIN_VALUE;
            } else {
                left1 = nums1[partition1 - 1]; // Partition ke just left wala nums1 ka element
            }

            // Agar nums1 ke saare elements left partition mein hain toh largest possible value maanenge
            if (partition1 == n1) {
                right1 = Integer.MAX_VALUE;
            } else {
                right1 = nums1[partition1]; // Partition ke just right wala nums1 ka element
            }

            // Agar nums2 se left partition mein koi element nahi liya toh smallest possible value maanenge
            if (partition2 == 0) {
                left2 = Integer.MIN_VALUE;
            } else {
                left2 = nums2[partition2 - 1]; // Partition ke just left wala nums2 ka element
            }

            // Agar nums2 ke saare elements left partition mein hain toh largest possible value maanenge
            if (partition2 == n2) {
                right2 = Integer.MAX_VALUE;
            } else {
                right2 = nums2[partition2]; // Partition ke just right wala nums2 ka element
            }

            // Correct partition tab milega jab dono arrays ke left elements dono right elements se chhote ya equal hon
            if (left1 <= right2 && left2 <= right1) {

                // Agar total elements odd hain toh left partition ka maximum element hi median hoga
                if (totalLength % 2 == 1) {
                    return Math.max(left1, left2);
                } else {

                    // Even case mein left partition ka maximum aur right partition ka minimum middle elements honge
                    int maxLeft = Math.max(left1, left2);
                    int minRight = Math.min(right1, right2);

                    // Dono middle elements ka average median hoga
                    return (maxLeft + minRight) / 2.0;
                }

            } else if (left1 > right2) {

                // left1 bada hai matlab nums1 se zyada elements left mein le liye, isliye partition left move karenge
                high = partition1 - 1;

            } else {

                // left2 bada hai matlab nums1 se kam elements left mein liye, isliye partition right move karenge
                low = partition1 + 1;
            }
        }

        // Valid sorted arrays ke case mein yaha normally kabhi nahi aayega
        return 0.0;








        // int n1 = nums1.length; 
        // int n2 = nums2.length;

        // int n = n1 + n2; 

        // int index2 = n / 2; // Median ka right/second index
        // int index1 = index2 - 1; // Median ka left/first index

        // int count = 0; // Virtual merged array mein current index track karega

        // int elem1 = -1, elem2 = -1; // Median ke 2 required elements store karenge

        // int i = 0, j = 0; // i -> nums1, j -> nums2 ko traverse karega

        // // Dono arrays mein elements available hain tab tak compare karenge
        // while (i < n1 && j < n2) {

        //     if (nums1[i] < nums2[j]) {

        //         // Agar current position median ke left index par hai
        //         if (count == index1) {
        //             elem1 = nums1[i]; // Left median element store karo
        //         }

        //         // Agar current position median ke right index par hai
        //         if (count == index2) {
        //             elem2 = nums1[i]; // Right median element store karo
        //         }

        //         count++; // Virtual merged array ka index increase
        //         i++; // nums1 mein next element par move
        //     }

        //     // nums2 ka current element chhota/equal hai
        //     else {

        //         // Agar current position median ke left index par hai
        //         if (count == index1) {
        //             elem1 = nums2[j]; // Left median element store karo
        //         }

        //         // Agar current position median ke right index par hai
        //         if (count == index2) {
        //             elem2 = nums2[j]; // Right median element store karo
        //         }

        //         count++; // Virtual merged array ka index increase
        //         j++; // nums2 mein next element par move
        //     }
        // }

        // // Agar nums1 mein abhi elements bach gaye hain
        // while (i < n1) {

        //     // Median ke left element ko find karo
        //     if (count == index1) {
        //         elem1 = nums1[i];
        //     }

        //     // Median ke right element ko find karo
        //     if (count == index2) {
        //         elem2 = nums1[i];
        //     }

        //     count++; // Next virtual index
        //     i++; // nums1 ka next element
        // }

        // // Agar nums2 mein abhi elements bach gaye hain
        // while (j < n2) {

        //     // Median ke left element ko find karo
        //     if (count == index1) {
        //         elem1 = nums2[j];
        //     }

        //     // Median ke right element ko find karo
        //     if (count == index2) {
        //         elem2 = nums2[j];
        //     }

        //     count++; // Next virtual index
        //     j++; // nums2 ka next element
        // }

        // // Agar total elements odd hain
        // if (n % 2 == 1) {
        //     return elem2; // Sirf middle/right element hi median hoga
        // }

        // // Agar total elements even hain
        // // Median = dono middle elements ka average
        // return (double) (elem1 + elem2) / 2.0;








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