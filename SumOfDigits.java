class Solution {

    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        return addDigits(sumDigits(num));
    }

    int sumDigits(int n) {
        if (n == 0) return 0;
        return (n % 10) + sumDigits(n / 10);
    }
}
