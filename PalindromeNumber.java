class Solution {
    public boolean isPalindrome(int n) {
        int original = n, reversed = 0;

        // Negative numbers are not palindrome
        if (n < 0) return false;

        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }

        return original == reversed;
    }
}
