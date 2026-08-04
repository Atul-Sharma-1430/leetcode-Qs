class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        int i = 0;
        while (i < nums.length - 3) {
            int first = nums[i];

            if (i != 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            int j = i + 1;
            while (j < nums.length - 2) {
                int second = nums[j];

                // agar j > i+1 nhi krte toh us time hum basically nums[j] > numns[i] checkkr rhe hote cz i = j+1 only, jo humey nhi krna humey j index ki values se compare krna hai 
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    long sum = (long) first + second + nums[k] + nums[l];

                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        ans.add(new ArrayList<>(Arrays.asList(first, second, nums[k], nums[l])));
                        
                        while (k < l && nums[k] == nums[k + 1]) {
                            k++;
                        }

                        while (k < l && nums[l] == nums[l - 1]) {
                            l--;
                        }

                        k++;
                        l--;
                    }
                }

                j++;
            }

            i++;
        }

        return ans;

    }
}