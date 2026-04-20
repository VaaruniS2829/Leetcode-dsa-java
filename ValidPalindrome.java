class Solution {
    public boolean isPalindrome(String s) {
        // remove non-alphanumeric and convert to lowercase
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // reverse the string
        String reversed = new StringBuilder(cleaned).reverse().toString();
        
        // compare
        return cleaned.equals(reversed);
    }
}
