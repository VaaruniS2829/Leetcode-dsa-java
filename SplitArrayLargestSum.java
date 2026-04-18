class Solution {

    private boolean canSplit(int[] nums, int k, long maxSum) {
        int parts = 1;
        long sum = 0;

        for (int num : nums) {
            if (num > maxSum) return false;

            if (sum + num <= maxSum) {
                sum += num;
            } else {
                parts++;
                sum = num;

                if (parts > k) return false;
            }
        }

        return true;
    }

    public int splitArray(int[] nums, int k) {
        long low = 0, high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                ans = mid;
                high = mid - 1;   // try smaller max sum
            } else {
                low = mid + 1;    // need bigger limit
            }
        }

        return (int) ans;
    }
}
