import java.util.Arrays;

class Solution {
    public int findMinDiff(int[] arr, int m) {
        int n = arr.length;

        if (m > n) return -1;

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= n - m; i++) {
            int diff = arr[i + m - 1] - arr[i];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
}
