import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Add all elements to set
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int longest = 0;

        // Check each number
        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            // Start only if previous number is not present
            if (!set.contains(num - 1)) {

                int current = num;
                int count = 1;

                // Count forward
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                if (count > longest) {
                    longest = count;
                }
            }
        }

        return longest;
    }
}
