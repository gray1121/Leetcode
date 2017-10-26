class Solution {
    public int divide(int dividend, int divisor) {
        // divisor case
        if (divisor == 0) { return Integer.MAX_VALUE; }
        // dividend overflow case
        // Integer.MIN_VALUE = -(Integer.MAX_VALUE + 1)
        if (dividend == Integer.MIN_VALUE && divisor == -1) { return Integer.MAX_VALUE; }
        long pDivisor = Math.abs((long)divisor);
        long pDividend = Math.abs((long)dividend);
        int num = 0;
        while (pDividend >= pDivisor) {
            int count = 0;
            while (pDividend >= (pDivisor << count) ) {
                count++;
            }
            // count is 1 larger this time
            --count;
            pDividend -= pDivisor << count;
            num += 1 << count;
        }
        if ((divisor > 0 && dividend > 0) || (divisor < 0 && dividend < 0)) { return num; }
        return -num;
    }
}