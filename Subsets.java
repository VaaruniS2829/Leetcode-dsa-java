import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> curr) {
        if (index == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        // Include
        curr.add(nums[index]);
        backtrack(nums, index + 1, curr);

        // Exclude
        curr.remove(curr.size() - 1);
        backtrack(nums, index + 1, curr);
    }
}
