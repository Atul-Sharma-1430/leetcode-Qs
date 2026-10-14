class Solution {
    public void sortColors(int[] array) {
        int left = 0;
        int mid = 0;
        int right = array.length - 1;

        while (mid <= right) {
            if (array[mid] == 0) {
                int temp = array[left];
                array[left] = array[mid];
                array[mid] = temp;
                left++;
                mid++;
            } else if (array[mid] == 1) {
                mid++;
            } else {
                int temp = array[mid];
                array[mid] = array[right];
                array[right] = temp;
                right--;
            }
        }










        // for (int j : array) {
        //     if (j == 0) zeros++;
        //     else if (j == 1) ones++;
        //     else twos++;
        // }

        // int index = 0;
        // while(zeros != 0) {
        //     array[index] = 0;
        //     index++;
        //     zeros--;
        // }

        // while(ones != 0) {
        //     array[index] = 1;
        //     index++;
        //     ones--;
        // }

        // while(twos != 0) {
        //     array[index] = 2;
        //     index++;
        //     twos--;
        // }
    }
}