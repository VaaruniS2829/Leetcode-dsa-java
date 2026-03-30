class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        
        int currMax = 0, maxSum = Integer.MIN_VALUE;
        int currMin = 0, minSum = Integer.MAX_VALUE;

        for (int num : nums) {
            // Max subarray (Kadane)
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            // Min subarray
            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);

            totalSum += num;
        }

        // Edge case: all elements negative
        if (maxSum < 0) return maxSum;

        return Math.max(maxSum, totalSum - minSum);
    }
}
