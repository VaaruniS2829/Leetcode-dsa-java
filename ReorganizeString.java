import java.util.*;

class Solution {
    public String reorganizeString(String s) {

        int[] freq = new int[26];

        // Count frequency
        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Max Heap based on frequency
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[1] - a[1]);

        // Add characters to heap
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();

        while(pq.size() >= 2) {

            int[] first = pq.poll();
            int[] second = pq.poll();

            // Add both characters
            result.append((char)(first[0] + 'a'));
            result.append((char)(second[0] + 'a'));

            // Reduce frequency
            first[1]--;
            second[1]--;

            // Add back if still remaining
            if(first[1] > 0) pq.offer(first);
            if(second[1] > 0) pq.offer(second);
        }

        // If one character left
        if(!pq.isEmpty()) {

            int[] last = pq.poll();

            // If frequency > 1, impossible
            if(last[1] > 1) return "";

            result.append((char)(last[0] + 'a'));
        }

        return result.toString();
    }
}
