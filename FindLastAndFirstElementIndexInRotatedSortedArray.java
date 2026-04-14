class Solution {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{
            findBound(nums, target, true),   // first
            findBound(nums, target, false)  // last
        };
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int l = 0, h = nums.length - 1;
        int ans = -1;

        while (l <= h) {
            int m = (l + h) / 2;

            if (nums[m] == target) {
                ans = m;
                if (isFirst) {
                    h = m - 1; // move left
                } else {
                    l = m + 1; // move right
                }
            }

            // Left half sorted
            else if (nums[l] <= nums[m]) {
                if (target >= nums[l] && target < nums[m]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            }

            // Right half sorted
            else {
                if (target > nums[m] && target <= nums[h]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }

        return ans;
    }
}
