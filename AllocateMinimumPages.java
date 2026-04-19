class Solution {

    static boolean isPossible(int[] arr, int k, int maxPages) {
        int students = 1;
        int pages = 0;

        for (int i = 0; i < arr.length; i++) {
            if (pages + arr[i] <= maxPages) {
                pages += arr[i];
            } else {
                students++;
                pages = arr[i];

                if (students > k) return false;
            }
        }
        return true;
    }

    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1;

        int low = 0, high = 0;

        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
