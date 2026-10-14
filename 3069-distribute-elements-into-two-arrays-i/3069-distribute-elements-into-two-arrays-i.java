class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        // First element arr1 mein aur second element arr2 mein jayega
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        // Third element se traverse karna start karenge
        for (int i = 2; i < nums.length; i++) {
            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                // Agar arr1 ka last element bada hai toh curr elem ko arr1 mein add karo
                arr1.add(nums[i]);
            } else {
                // else usko arr2 mein add karo
                arr2.add(nums[i]);
            }
        }

        // copying to result array
        int[] result = new int[nums.length];
        int index = 0;

        for (int i = 0; i < arr1.size(); i++) {
            result[index++] = arr1.get(i);
        }

        for (int i = 0; i < arr2.size(); i++) {
            result[index++] = arr2.get(i);
        }

        return result;
    }
}