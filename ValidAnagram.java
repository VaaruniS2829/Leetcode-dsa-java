class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        // Count characters in s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Subtract using t
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }

        // Check if all are zero
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
