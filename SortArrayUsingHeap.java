class Solution {

    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] arr) {
        int n = arr.length;

        // Build Max Heap (O(n))
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements (O(n log n))
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);      // move max to end
            heapify(arr, i, 0);   // heapify reduced heap
        }
    }

    private void heapify(int[] arr, int n, int i) {
        while (true) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && arr[left] > arr[largest]) {
                largest = left;
            }

            if (right < n && arr[right] > arr[largest]) {
                largest = right;
            }

            if (largest == i) break;

            swap(arr, i, largest);
            i = largest; // continue heapifying down
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
