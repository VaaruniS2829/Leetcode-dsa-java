import java.util.*;

class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // Step 1

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;              // same as left
            int k = nums.length - 1;   // same as right

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Skip duplicates for j
                    while (j < k && nums[j] == nums[j + 1]) j++;

                    // Skip duplicates for k
                    while (j < k && nums[k] == nums[k - 1]) k--;

                    j++;
                    k--;
                } 
                else if (sum < 0) {
                    j++; // move forward
                } 
                else {
                    k--; // move backward
                }
            }
        }

        return result;
    }
}
