class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {
            int length = right - left;
            int breadth = Math.min(height[right], height[left]);
            long area = length * breadth;

            if (area > maxArea) {
                maxArea = (int) area;
            }

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}