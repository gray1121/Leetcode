public class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if (x == 1) return 1;
        if (x == -1) {
            if (n % 2 == 0) return 1;
            else return -1;
        }
        if (n == Integer.MIN_VALUE) return 0;
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        return n%2 == 0 ? myPow(x*x,  n/2) : myPow(x, n - 1) * x;
    }
}