class Solution {

    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        if (m > n)
            return -1;

        int d = 256;
        int q = 101;

        int h = 1;

        int p = 0; // pattern hash
        int t = 0; // text window hash

        // Calculate h = pow(d, m-1) % q
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Initial hash values
        for (int i = 0; i < m; i++) {
            p = (d * p + needle.charAt(i)) % q;
            t = (d * t + haystack.charAt(i)) % q;
        }

        // Sliding window
        for (int i = 0; i <= n - m; i++) {

            // Hash match
            if (p == t) {

                int j;

                for (j = 0; j < m; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j))
                        break;
                }

                // Pattern found
                if (j == m)
                    return i;
            }

            // Calculate next window hash
            if (i < n - m) {

                t = (d * (t - haystack.charAt(i) * h)
                        + haystack.charAt(i + m)) % q;

                // Make positive
                if (t < 0)
                    t += q;
            }
        }

        return -1;
    }
}
